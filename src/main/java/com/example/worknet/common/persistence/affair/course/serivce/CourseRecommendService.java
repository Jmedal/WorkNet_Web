package com.example.worknet.common.persistence.affair.course.serivce;

import com.baomidou.mybatisplus.service.IService;
import com.example.worknet.common.persistence.template.modal.CourseRecommend;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 职业推荐课程表 服务类
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-06-04
 */
public interface CourseRecommendService extends IService<CourseRecommend> {

    List<HashMap<String,Object>> getUserProfession(Long uid);
}
