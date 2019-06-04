package com.example.worknet.common.persistence.affair.course.serviceImpl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.worknet.common.persistence.template.modal.CourseStudied;
import com.example.worknet.common.persistence.template.dao.CourseStudiedMapper;
import com.example.worknet.common.persistence.affair.course.serivce.CourseStudiedService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.worknet.core.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 用户学习课程记录表 服务实现类
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@Service
public class CourseStudiedServiceImpl extends ServiceImpl<CourseStudiedMapper, CourseStudied> implements CourseStudiedService {

    /**
     * 获取用户报名课程时间
     * @param uid
     * @param cid
     * @return
     */
    @Override
    public String getStudiedTime(long uid, long cid) {
        List<CourseStudied> courseStudiedList = super.selectList(new EntityWrapper<CourseStudied>().eq("user_id",uid).eq("course_id",cid));
        if(courseStudiedList != null && courseStudiedList.size() != 0)
            return DateUtil.stampToDate(courseStudiedList.get(0).getStartTime(),DateUtil.YMD_TIME);
        else
            return null;
    }

    /**
     * 获取用户参加的所有课程
     * @param page
     * @param uid
     * @return
     */
    @Override
    public Page<HashMap<String, Object>> getUserStudiedPage(Page<HashMap<String, Object>> page, long uid) {
        return page.setRecords(courseStudiedMapper.getUserStudiedPage(page, uid));
    }

    @Autowired
    private CourseStudiedMapper courseStudiedMapper;
}
