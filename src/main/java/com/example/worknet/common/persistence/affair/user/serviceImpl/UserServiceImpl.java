package com.example.worknet.common.persistence.affair.user.serviceImpl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.worknet.common.constant.Const;
import com.example.worknet.common.persistence.affair.company.serivce.CompanyContestApplyService;
import com.example.worknet.common.persistence.affair.course.serivce.CourseStudiedService;
import com.example.worknet.common.persistence.affair.user.serivce.CompanyService;
import com.example.worknet.common.persistence.affair.user.serivce.LearnerInfoService;
import com.example.worknet.common.persistence.affair.user.serivce.TeacherInfoService;
import com.example.worknet.common.persistence.affair.user.serivce.UserService;
import com.example.worknet.common.persistence.template.modal.*;
import com.example.worknet.common.persistence.template.dao.UserMapper;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.worknet.core.utils.FileToolsUtil;
import com.example.worknet.core.utils.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;


/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    /**
     * 验证用户帐号密码
     * @param account
     * @param password
     * @return
     */
    @Override
    public boolean verify(String account, String password) {
        List<User> userList = userService.selectList(new EntityWrapper<User>().eq("account",account));
        if(userList.size() != 0 &&
                userList.get(0).getPassword().equals(password)){
            return true;
        }
        return false;
    }

    /**
     * 检查用户帐号是否存在
     * @param account
     * @return
     */
    @Override
    public boolean checkAccount(String account) {
        List<User> userList = userService.selectList(new EntityWrapper<User>().eq("account",account));
        if(userList.size() != 0)
            return true;
        return false;
    }

    /**
     * 获取用户所有信息
     * @param user
     * @return
     */
    @Override
    public HashMap<String,Object> getUserInfo(User user) {
        int role=user.getRole();
        switch (role){
            case 3:
                return userMapper.getLearnerInfo(user.getId());
            case 2:
                return userMapper.getTeacherInfo(user.getId());
            case 1:
                return userMapper.getCompanyInfo(user.getId());
            default:
                return null;
        }
    }

    /**
     * 获取用户昵称
     * @param id
     * @return
     */
    @Override
    public String getNickname(Long id) {
        int role = userService.selectById(id).getRole();
        switch (role){
            case 3:
                return learnerInfoService.selectOne(new EntityWrapper<LearnerInfo>().eq("user_id",id)).getNickname();
            case 2:
                return teacherInfoService.selectOne(new EntityWrapper<TeacherInfo>().eq("user_id",id)).getRealname();
            case 1:
                return companyService.selectOne(new EntityWrapper<Company>().eq("user_id",id)).getName();
            default:
                return null;
        }
    }

    /**
     * 账号注册
     * @param user
     * @return
     */
    @Override
    public boolean userRegister(User user) {
        int role=user.getRole();
        if(role == 0)
            return false;
        userService.insert(user);
        user = userService.selectOne(new EntityWrapper<User>().eq("account",user.getAccount()));
        switch (role){
            case 3:
                LearnerInfo learnerInfo = new LearnerInfo();
                learnerInfo.setUserId(user.getId());
                learnerInfo.setNickname(RandomString.getRandomString(6));
                learnerInfoService.insert(learnerInfo);
                return true;
            case 2:
                TeacherInfo teacherInfo = new TeacherInfo();
                teacherInfo.setUserId(user.getId());
                teacherInfoService.insert(teacherInfo);
                return true;
            case 1:
                Company company = new Company();
                company.setUserId(user.getId());
                companyService.insert(company);
                return true;
            default:
                return false;
        }
    }

    /**
     *添加讲师信息
     * @param teacherInfo
     * @return
     */
    @Override
    public boolean insertTeacherInfo(TeacherInfo teacherInfo) {
        return teacherInfoService.insert(teacherInfo);
    }

    /**
     *添加学生信息
     * @param learnerInfo
     * @return
     */
    @Override
    public boolean insertLearnerInfo(LearnerInfo learnerInfo) {
        return learnerInfoService.insert(learnerInfo);
    }

    /**
     * 更新用户基础信息
     * @param user
     * @return
     */
    @Override
    public boolean updateUserInfo(User user) {
        if(user.getId()==null)
            return false;
        return userService.updateById(user);
    }

    /**
     * 更新讲师信息
     * @param teacherInfo
     * @return
     */
    @Override
    public boolean updateTeacherInfo(TeacherInfo teacherInfo) {
        return teacherInfoService.updateById(teacherInfo);
    }

    /**
     * 更新学生信息
     * @param learnerInfo
     * @return
     */
    @Override
    public boolean updateLearnerInfo(LearnerInfo learnerInfo) {
        if(learnerInfo.getUserId()==null)
            return false;
        learnerInfo.setId(learnerInfoService.selectOne(new EntityWrapper<LearnerInfo>().eq("user_id",learnerInfo.getUserId())).getId());
        return learnerInfoService.updateById(learnerInfo);
    }

    /**
     * 获取用户头像
     * @param userId
     * @return
     */
    @Override
    public Resource getAvatar(long userId, String strDirPath) {
        User user = userService.selectById(userId);
        if(user==null)
            throw new RuntimeException();
        //绝对保存路径
        String filePath = Const.FILE_PATH + user.getHeadPath();
        strDirPath = strDirPath + "WEB-INF" + Const.FILE_SEPARATOR + "classes" + Const.FILE_SEPARATOR + "static" + Const.FILE_SEPARATOR + "upload";
        FileToolsUtil.fileToUpload(strDirPath, filePath);
        return resourceLoader.getResource("file:" + strDirPath + Const.FILE_SEPARATOR + filePath.substring(filePath.lastIndexOf(Const.FILE_SEPARATOR) + 1));
    }

    /**
     * 更新用户头像
     * @param userId
     * @return
     */
    @Override
    public boolean updateAvatar(long userId,MultipartHttpServletRequest request) {
        User user = userService.selectById(userId);
        if(user==null)
            return false;
        if(user.getHeadPath()!=null&&!user.getHeadPath().equals("")&&!user.getHeadPath().equals(userService.selectById(1).getHeadPath()))
            FileToolsUtil.deleteFile(Const.FILE_PATH + user.getHeadPath());//删除旧图片
        //相对保存路径
        String file_path = Const.FILE_SEPARATOR + Const.HEAD_PATH + Const.FILE_SEPARATOR + Calendar.getInstance().get(Calendar.YEAR);
        //绝对保存路径
        String file_full_path = Const.FILE_PATH + file_path;
        //保存头像
        String file_name = FileToolsUtil.fileUpload(request.getFile("avatar"),FileToolsUtil.createDiretory(file_full_path));
        //更新数据库路径信息
        user.setHeadPath(file_path + Const.FILE_SEPARATOR + file_name);
        userService.updateById(user);
        return true;
    }

    /**
     * 获取用户参加的所有课程
     * @param page
     * @param uid
     * @return
     */
    @Override
    public Page<HashMap<String, Object>> getUserStudiedPage(Page<HashMap<String, Object>> page, long uid) {
        return courseStudiedService.getUserStudiedPage(page,uid);
    }

    /**
     * 获取用户笔试报名记录
     * @param page
     * @param uid
     * @return
     */
    @Override
    public Page<HashMap<String, Object>> getUserContestPage(Page<HashMap<String, Object>> page, Long uid) {
        return companyContestApplyService.getUserContestPage(page, uid);
    }

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TeacherInfoService teacherInfoService;

    @Autowired
    private LearnerInfoService learnerInfoService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CompanyContestApplyService companyContestApplyService;

    @Autowired
    private CourseStudiedService courseStudiedService;

    @Autowired
    private final ResourceLoader resourceLoader;

    @Autowired
    public UserServiceImpl(ResourceLoader resourceLoader){
        this.resourceLoader = resourceLoader;
    }
}
