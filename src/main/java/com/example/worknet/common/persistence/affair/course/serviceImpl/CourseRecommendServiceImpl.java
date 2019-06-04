package com.example.worknet.common.persistence.affair.course.serviceImpl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.worknet.common.persistence.affair.course.serivce.CourseRecommendService;
import com.example.worknet.common.persistence.template.dao.CourseRecommendMapper;
import com.example.worknet.common.persistence.template.dao.UserProfessionMapper;
import com.example.worknet.common.persistence.template.modal.CourseRecommend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 职业推荐课程表 服务实现类
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-06-04
 */
@Service
public class CourseRecommendServiceImpl extends ServiceImpl<CourseRecommendMapper, CourseRecommend> implements CourseRecommendService {

    /**
     * 用户的推荐课程
     * @param uid
     * @return
     */
    @Override
    public List<HashMap<String, Object>> getUserProfession(Long uid) {
        return courseRecommendMapper.getUserRecommendCurriculum(uid);
    }

    @Autowired
    private CourseRecommendMapper courseRecommendMapper;
}
