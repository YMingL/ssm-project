import com.alibaba.druid.sql.ast.statement.SQLForeignKeyImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.webgraduation.controller.SearchController;
import com.webgraduation.entity.Goods;
import com.webgraduation.entity.ZdCategory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.crypto.Mac;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-*.xml","classpath:mybatis/mybatis-config.xml"})
@WebAppConfiguration
public class Test {

    @Resource
    private RedisTemplate redisTemplate;

    @Autowired
    private SearchController searchController;


//    redis测试
/*    @org.junit.Test
    public void test(){
        redisTemplate.opsForValue().set("hello","world");
    }*/


//    SearchController层  获取分类测试
/*    @org.junit.Test
    public void test(){
        List<ZdCategory> categoryList = searchController.getCategoryList();
        categoryList.toString();
    }*/


//searchController层  获取商品测试
//    @org.junit.Test
//    public void test(){
//       String str = searchController.getGoodsPageByName(1,20,"牛仔");
//       Map<String,Object> maps = (Map<String ,Object>)JSON.parse(str);
//
//       List<Object> goods = (List<Object>) maps.get("goodsList");
//       for (Object good : goods){
//           System.out.println(good.toString());
//       }
//    }


//   正则匹配测试
    @org.junit.Test
    public void test(){
        String num = "1224--jjk";
        Matcher matcher = Pattern.compile("-").matcher(num);
        boolean b = matcher.find();
        System.out.println(b);

    }


}
