package com.yang.shop.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yang.shop.dto.PageParam;
import com.yang.shop.dto.SqlParams;
import com.yang.shop.dto.UserGoldInfo;
import com.yang.shop.entity.Goods;
import com.yang.shop.entity.User;
import com.yang.shop.entity.ZdCategory;
import com.yang.shop.service.GoodsService;
import com.yang.shop.service.UserService;
import com.yang.shop.service.ZdCategoryService;
import com.yang.shop.util.DateUtil.DateUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by acer on 2019-12-23.
 */

@Controller
public class SearchController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private UserService userService;
    @Autowired
    private ZdCategoryService zdCategoryService;

    @Autowired
    RedisCacheManager cacheManager;


    /**
     * 获取商品列表
     * @param pageNum
     * @param pageSize
     * @param goodsName
     * @return
     */
    @RequestMapping(value = "/GoodsList",method = RequestMethod.POST,produces = {"application/text;charset=UTF-8"})
    @ResponseBody
    public String getGoodsPageByName(@RequestParam(value = "pageNum",required = false) int pageNum,
                                           @RequestParam(value = "pageSize",required = false) int pageSize,
                                           @RequestParam(value = "goodsName",required = false) String goodsName,
                                     @RequestParam(value = "brandName",required = false) String brandName,
                                     @RequestParam(value = "price",required = false) String price
                                     ){
        Map<String ,Object> map = new HashMap<>();
        //计算取数据范围
        int pageStart = (pageNum-1)*pageSize + 1; //页面第一条数据
        PageParam pageParam = PageParam.getInstance(goodsName,pageStart-1,pageSize,brandName,price);
//        获取商品数据
        List<Goods> goodsList = goodsService.getPageList(pageParam);
        map.put("goodsList",goodsList);
//        获取商品数量
        int goodsNum =  goodsService.getGoodsNum(pageParam);
        map.put("goodsNum",goodsNum);
        return new JSONObject(map).toString();
    }


    /**
     * 返回分类列表
     * @return
     */
    @RequestMapping("/getCategory")
    @ResponseBody
    public List<ZdCategory> getCategoryList(){
        List<ZdCategory> zdCategories = zdCategoryService.getCategoryList();
        return  zdCategories;
    }

    /**
     * 添加用户金币赠送功能
     * 优化重复代码
     * @param
     * @return
     */
    @RequestMapping(value = "/getGoldInfo",method = RequestMethod.POST,produces = {"application/text;charset=UTF-8"})
    @ResponseBody
    public String getUserGoldInfo(@RequestParam("userName") String userName){
/*        利用数组存储用户每日获得金币数，登陆时，若当天金币数为0，则表示首次登陆，反之则不是首次，
        若上一个数组元素为零，则表示前一天未登录，赠送金币数应重新计数，反之金币数 +1
        金币数量存入mysql数据库，数组存入redis，每天更新一次数据库，显示则用redis累加*/
        Cache cache = cacheManager.getCache("userGold"); //获取Cache
        Calendar calendar= Calendar.getInstance();
        //1、从redis中获取数据，若没有则创建
        UserGoldInfo userGold = cache.get(userName+"_Gold",UserGoldInfo.class);
        System.out.println("====>there");
        Calendar calendar_old = Calendar.getInstance();
        if (userGold != null) {
            calendar_old.setTimeInMillis(userGold.getMillis());//获取上次登陆时间
        }

        if (userGold  == null){
//首次登陆
            UserGoldInfo userGoldInfo = new UserGoldInfo();
            //取得当前时间
            userGoldInfo.setMillis(calendar.getTimeInMillis());
            if(calendar.get(Calendar.DAY_OF_WEEK)-1 == 0){
                userGoldInfo.setGoldNum(7,1);
            }else {
                userGoldInfo.setGoldNum(calendar.get(Calendar.DAY_OF_WEEK)-1,1);
            }
            //更新redis
            cache.put(userName+"_Gold",userGoldInfo);
            SqlParams sqlParams = new SqlParams(userName,1);
            //更新数据库
            userService.updateUserGold(sqlParams);
            //后续添加异常处理添加失败，
            return new JSONObject(userGoldInfo).toString();
        }else if (calendar.get(Calendar.YEAR) == calendar_old.get(Calendar.YEAR) && calendar.get(Calendar.MONTH) == calendar_old.get(Calendar.MONTH) && calendar.get(Calendar.DAY_OF_MONTH) == calendar_old.get(Calendar.DAY_OF_MONTH)){
            return null;//同一天登陆  测试注释
//            return new JSONObject(userGold).toString();
        }else if(calendar.get(Calendar.DAY_OF_WEEK)-1 == 1) {  //判断当前登陆时间是否为周一
            userGold.empty();//清除以前的数据
            //设置新数据
            userGold.setMillis(calendar.getTimeInMillis());
            userGold.setGoldNum(1,1);
            //更新redis
            cache.put(userName+"_Gold",userGold);
            userService.updateUserGold(new SqlParams(userName,1));
            return  new JSONObject(userGold).toString();
        } else if(DateUtil.isInWeek(calendar_old.getTimeInMillis(),calendar.getTimeInMillis())){ //周内连续
            userGold.setMillis(calendar.getTimeInMillis());
            if(calendar.get(Calendar.DAY_OF_WEEK) -1 == 0){
                userGold.setGoldNum(7,userGold.getGoldNum(6)+1);
                cache.put(userName+"_Gold",userGold);
                userService.updateUserGold(new SqlParams(userName,userGold.getGoldNum(7)));
            }else {
                userGold.setGoldNum(calendar.get(Calendar.DAY_OF_WEEK)-1,userGold.getGoldNum(calendar.get(Calendar.DAY_OF_WEEK)-1-1)+1);
                cache.put(userName+"_Gold",userGold);
                userService.updateUserGold(new SqlParams(userName,userGold.getGoldNum(calendar.get(Calendar.DAY_OF_WEEK)-1)));
            }
            return new JSONObject(userGold).toString();
        } else if(!DateUtil.isInWeek(calendar_old.getTimeInMillis(),calendar.getTimeInMillis())){//不连续周
            userGold.empty();
            userGold.setMillis(calendar.getTimeInMillis());
            if (calendar.get(Calendar.DAY_OF_WEEK)-1 == 0){
                userGold.setGoldNum(7,1);
            }else {
                userGold.setGoldNum(calendar.get(Calendar.DAY_OF_WEEK)-1,1);
            }
            cache.put(userName+"_Gold",userGold);
            userService.updateUserGold(new SqlParams(userName,1));
            return new JSONObject(userGold).toString();
        }
        return null;
    }


    /**
     * 登陆验证
     * @param request
     * @param response
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping(value="/loginVerify",method = RequestMethod.POST,produces = {"application/text;charset=UTF-8"})
    @ResponseBody
    public String loginVerify(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        Cache cache = cacheManager.getCache("userInfo");
        Map<String ,Object> map = new HashMap<>();
        String username = request.getParameter("userName");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        User user = userService.getUserByName(username);
        try {
             if (user == null) {
                map.put("code", 0);
                map.put("msg", "用户名无效");
            } else if (!user.getPassword().equals(password)) {
                map.put("code", 0);
                map.put("msg", "密码错误");
            } else {
                map.put("code", 1);
                map.put("msg", "");
                //添加session
                request.getSession().setAttribute("user", user);
                 Cookie nameCookie = new Cookie("userName", URLEncoder.encode(username, "utf-8"));
                 nameCookie.setMaxAge(60*60*24*3);
                 response.addCookie(nameCookie);
                //如果有记住密码，则添加cookie
                if (remember != null) {
                    Cookie passCookie = new Cookie("password", URLEncoder.encode(password, "utf-8"));
                    passCookie.setMaxAge(60*60*24*3);
                    response.addCookie(passCookie);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String result = new JSONObject(map).toString();
        return result;
    }

    //退出登陆
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        session.invalidate();//session失效
        return "redirect:/index.html";
    }
}
