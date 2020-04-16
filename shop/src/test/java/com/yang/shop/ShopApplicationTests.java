package com.yang.shop;

import com.yang.shop.Controller.SearchController;
import com.yang.shop.entity.User;
import com.yang.shop.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.sql.DataSource;
import java.sql.Connection;

import static org.assertj.core.api.Assertions.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ShopApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    RedisCacheManager cacheManager;

    @Autowired
    UserService userService;

    @Autowired
    SearchController searchController;

    @Autowired
    MockMvc mockMvc;

/*    @Test
    void contextLoads() throws Exception {
        System.out.println("=====>"+dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println("=====>"+connection);
        connection.close();
    }*/

//    测试redis缓存
//    @Test
//    void contextLoads() throws Exception {
//        Cache userInfo =  cacheManager.getCache("userInfo");
//        User user = userService.getUserByName("admin");
//        User user1 = userService.getUserByName("admin1");
//        userInfo.put("admin",user);
//        userInfo.put("admin",user1);
////        User user1 = userInfo.get("admin_info",User.class);
////        System.out.println(user1.toString());
////        System.out.println(user1);
//    }

//     测试service层
//    @Test
//    void test(){
//        User user = userService.getUserByName("admin1");
//        User user1 = userService.getUserByName("admin");
////        userInfo.put("user",user);
//        System.out.println(user);
//    }

//    测试controller层
//    @Test
//    void testController() throws Exception {
//        String json = "{\"userName\":\"admin\"}";
//        mockMvc.perform(MockMvcRequestBuilders.post("/getGoldInfo")
//                .accept(MediaType.APPLICATION_JSON)
//                .content(json.getBytes()))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
}
