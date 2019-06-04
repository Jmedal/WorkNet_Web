package com.example.worknet.controller.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.worknet.common.persistence.affair.course.controller.CourseStudiedController;
import com.example.worknet.common.persistence.affair.course.serivce.CourseService;
import com.example.worknet.common.persistence.affair.user.serivce.UserService;
import com.example.worknet.common.persistence.template.dao.CompanyContestApplyMapper;
import com.example.worknet.common.persistence.template.dao.CourseMapper;
import com.example.worknet.common.persistence.affair.user.serivce.AdministratorService;
import com.example.worknet.common.persistence.affair.course.serivce.CourseClickService;
import com.example.worknet.common.persistence.affair.user.serivce.TeacherInfoService;
import com.example.worknet.common.persistence.template.dao.CourseStudiedMapper;
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

    @Autowired
    private CourseService courseService;

    @Autowired
    private CompanyContestApplyMapper companyContestApplyMapper;

    @Autowired
    private CourseStudiedController courseStudiedController;

    @Test
    public void test() throws Exception {

//        System.out.println("3".hashCode());
//
//        TeacherInfo teacherInfo = teacherInfoService.selectById(1);
//
//        System.out.println(teacherInfo.toString());
//
//            User user = userService.selectList(new EntityWrapper<User>().eq("id",teacherInfo.getUserId())).get(0);
//
//        System.out.println(user);
//
//        System.out.println(teacherInfoService.selectList(new EntityWrapper<TeacherInfo>().eq("user_id",user.getId())));
//
//        System.out.println(administratorService.verify("admin","admin"));

//        User user = userService.selectList(new EntityWrapper<User>().eq("id",1)).get(0);
//        System.out.println(userService.getUserInfo(user));


        //Page<HashMap<String,Object>> questionPage = courseService.getCoursePage(new Page<>(0 ,9), CourseConst.COURSE_DEfAULT,"");
        //HashMap<String,Object> map = new HashMap<>();
        //map.put("errorCode","00");
        //map.put("returnObject",questionPage);

        System.out.println(companyContestApplyMapper.getUserCompanyContestPage(new Page<>(1,8),(long)3));


    }
}