package com.example.worknet.controller.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.worknet.common.persistence.affair.user.serivce.UserService;
import com.example.worknet.common.persistence.template.modal.TeacherInfo;
import com.example.worknet.common.persistence.template.modal.User;
import com.example.worknet.common.persistence.affair.user.serivce.AdministratorService;
import com.example.worknet.common.persistence.affair.course.serivce.CourseClickService;
import com.example.worknet.common.persistence.affair.user.serivce.TeacherInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试API
 * Service的测试类
 * @Author: YunJieJiang
 * @Date: Created in 2:20 2018/8/24 0024
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CourseClickTest {


    @Autowired
    private CourseClickService courseClickService;

    @Autowired
    private UserService userService;

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private TeacherInfoService teacherInfoService;

    @Test
    public void test() throws Exception {

        System.out.println("3".hashCode());

        TeacherInfo teacherInfo = teacherInfoService.selectById(1);

        System.out.println(teacherInfo.toString());

        User user = userService.selectList(new EntityWrapper<User>().eq("id",teacherInfo.getUserId())).get(0);

        System.out.println(user);

        System.out.println(teacherInfoService.selectList(new EntityWrapper<TeacherInfo>().eq("user_id",user.getId())));

        System.out.println(administratorService.verify("admin","admin"));

        System.out.println(userService.getUserInfo((long)1));
    }
}