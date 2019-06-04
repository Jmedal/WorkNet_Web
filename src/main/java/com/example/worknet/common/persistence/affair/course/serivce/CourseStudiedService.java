package com.example.worknet.common.persistence.affair.course.serivce;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.worknet.common.persistence.template.modal.CourseStudied;
import com.baomidou.mybatisplus.service.IService;

import java.util.HashMap;

/**
 * <p>
 * 用户学习课程记录表 服务类
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
public interface CourseStudiedService extends IService<CourseStudied> {

    String getStudiedTime(long uid, long cid);

    Page<HashMap<String,Object>> getUserStudiedPage(Page<HashMap<String, Object>> page, long uid);
}
