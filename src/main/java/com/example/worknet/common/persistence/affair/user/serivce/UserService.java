package com.example.worknet.common.persistence.affair.user.serivce;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.worknet.common.persistence.template.modal.LearnerInfo;
import com.example.worknet.common.persistence.template.modal.TeacherInfo;
import com.example.worknet.common.persistence.template.modal.User;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.HashMap;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
public interface UserService extends IService<User>{

    boolean verify(String account,String password);

    boolean checkAccount(String account);

    HashMap<String,Object> getUserInfo(User user);

    String getNickname(Long id);

    boolean userRegister(User user);

    boolean insertTeacherInfo(TeacherInfo teacherInfo);

    boolean insertLearnerInfo(LearnerInfo learnerInfo);

    boolean updateUserInfo(User user);

    boolean updateTeacherInfo(TeacherInfo teacherInfo);

    boolean updateLearnerInfo(LearnerInfo learnerInfo);

    Resource getAvatar(long userId, String strDirPath);

    boolean updateAvatar(long userId, MultipartHttpServletRequest request);

    Page<HashMap<String, Object>> getUserStudiedPage(Page<HashMap<String, Object>> page, long uid);

    Page<HashMap<String, Object>> getUserContestPage(Page<HashMap<String, Object>> page, Long uid);
}
