package com.example.worknet.common.persistence.affair.user.serviceImpl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.worknet.common.constant.Const;
import com.example.worknet.common.persistence.affair.user.serivce.LearnerInfoService;
import com.example.worknet.common.persistence.affair.user.serivce.TeacherInfoService;
import com.example.worknet.common.persistence.affair.user.serivce.UserService;
import com.example.worknet.common.persistence.template.modal.LearnerInfo;
import com.example.worknet.common.persistence.template.modal.TeacherInfo;
import com.example.worknet.common.persistence.template.modal.User;
import com.example.worknet.common.persistence.template.dao.UserMapper;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.worknet.core.utils.FileToolsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@Service
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
     * @param id
     * @return
     */
    @Override
    public Map<String,String> getUserInfo(Long id){
        return userMapper.getUserInfo(id);
    }

    /**
     * 账号注册
     * @param user
     * @return
     */
    @Override
    public boolean userRegister(User user) {
        return  userService.insert(user);
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
        String filePath = user.getHeadPath();
        strDirPath = strDirPath+"WEB-INF"+Const.FILE_SEPARATOR+"classes"+Const.FILE_SEPARATOR+"static"+Const.FILE_SEPARATOR+"upload";
        FileToolsUtil.fileToUpload(strDirPath,filePath);
        return resourceLoader.getResource("file:" + strDirPath + Const.FILE_SEPARATOR + filePath.substring(filePath.lastIndexOf(Const.FILE_SEPARATOR)+1));
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
            FileToolsUtil.deleteFile(user.getHeadPath());//删除旧图片
        //保存路径
        String file_path = Const.FILE_PATH+Const.FILE_SEPARATOR+Const.HEAD_PATH+ Const.FILE_SEPARATOR+ Calendar.getInstance().get(Calendar.YEAR);
        //保存头像
        String file_path_full = FileToolsUtil.fileUpload(request.getFile("first_image"),FileToolsUtil.createDiretory(file_path));
        //更新数据库路径信息
        user.setHeadPath(file_path_full);
        userService.updateById(user);
        return true;
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
    private final ResourceLoader resourceLoader;

    @Autowired
    public UserServiceImpl(ResourceLoader resourceLoader){
        this.resourceLoader = resourceLoader;
    }
}
