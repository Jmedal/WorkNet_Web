//package com.example.worknet.controller;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
///**
// * 测试API
// * Controller的测试类
// * @Author: YunJieJiang
// * @Date: Created in 2:20 2018/8/24 0024
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class GirlControllerTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @Autowired
//    private GirlService girlService;
//
//    @Test
//    public void test() throws Exception {
//        System.out.println(girlService.selectByMap(null));
//    }
//
//    @Test
//    public void getAllGirlTest() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/girls"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string("[{\"id\":23,\"cupSize\":\"D\",\"age\":15,\"money\":null},{\"id\":24,\"cupSize\":\"F\",\"age\":19,\"money\":null},{\"id\":25,\"cupSize\":\"D\",\"age\":18,\"money\":null},{\"id\":42,\"cupSize\":\"B\",\"age\":22,\"money\":null},{\"id\":43,\"cupSize\":\"B\",\"age\":21,\"money\":null},{\"id\":44,\"cupSize\":\"B\",\"age\":21,\"money\":null},{\"id\":45,\"cupSize\":\"B\",\"age\":21,\"money\":null},{\"id\":46,\"cupSize\":\"B\",\"age\":21,\"money\":null},{\"id\":47,\"cupSize\":\"B\",\"age\":21,\"money\":null},{\"id\":48,\"cupSize\":\"B\",\"age\":21,\"money\":null},{\"id\":49,\"cupSize\":\"B\",\"age\":21,\"money\":null},{\"id\":50,\"cupSize\":\"B\",\"age\":21,\"money\":null},{\"id\":51,\"cupSize\":\"B\",\"age\":21,\"money\":null},{\"id\":52,\"cupSize\":\"B\",\"age\":21,\"money\":null},{\"id\":53,\"cupSize\":\"B\",\"age\":21,\"money\":null},{\"id\":54,\"cupSize\":\"B\",\"age\":21,\"money\":null},{\"id\":55,\"cupSize\":\"B\",\"age\":21,\"money\":null},{\"id\":56,\"cupSize\":\"B\",\"age\":21,\"money\":null},{\"id\":57,\"cupSize\":\"B\",\"age\":21,\"money\":null},{\"id\":58,\"cupSize\":\"B\",\"age\":21,\"money\":null},{\"id\":59,\"cupSize\":\"B\",\"age\":21,\"money\":null},{\"id\":60,\"cupSize\":\"B\",\"age\":18,\"money\":null},{\"id\":61,\"cupSize\":\"B\",\"age\":18,\"money\":null},{\"id\":62,\"cupSize\":\"B\",\"age\":18,\"money\":null},{\"id\":63,\"cupSize\":\"B\",\"age\":18,\"money\":null},{\"id\":64,\"cupSize\":\"B\",\"age\":18,\"money\":null},{\"id\":65,\"cupSize\":\"B\",\"age\":22,\"money\":null},{\"id\":66,\"cupSize\":\"B\",\"age\":22,\"money\":null},{\"id\":67,\"cupSize\":\"B\",\"age\":22,\"money\":null},{\"id\":70,\"cupSize\":\"D\",\"age\":18,\"money\":null},{\"id\":71,\"cupSize\":\"F\",\"age\":19,\"money\":null},{\"id\":86,\"cupSize\":\"D\",\"age\":18,\"money\":null},{\"id\":88,\"cupSize\":\"D\",\"age\":18,\"money\":null},{\"id\":90,\"cupSize\":\"D\",\"age\":18,\"money\":null},{\"id\":92,\"cupSize\":\"D\",\"age\":18,\"money\":null},{\"id\":96,\"cupSize\":\"B\",\"age\":22,\"money\":null},{\"id\":97,\"cupSize\":\"A\",\"age\":30,\"money\":null},{\"id\":101,\"cupSize\":\"B\",\"age\":25,\"money\":1.0},{\"id\":102,\"cupSize\":\"B\",\"age\":25,\"money\":2.0}]"));
//    }
//}