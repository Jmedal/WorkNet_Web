package com.example.worknet.common.persistence.affair.video.serivce;

import com.example.worknet.common.persistence.template.modal.CourseVideo;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.core.io.Resource;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 课程视频表 服务类
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
public interface CourseVideoService extends IService<CourseVideo> {

    List<HashMap<String,Object>> getCourseVideoMenu(long cid, long uid);

    Resource getCourseVideo(long vId, String strDirPath);
}
