package com.example.worknet.common.persistence.affair.video.serviceImpl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.worknet.common.constant.Const;
import com.example.worknet.common.persistence.affair.course.serivce.CourseIndexService;
import com.example.worknet.common.persistence.affair.video.serivce.VideoWatchedService;
import com.example.worknet.common.persistence.template.modal.CourseIndex;
import com.example.worknet.common.persistence.template.modal.CourseVideo;
import com.example.worknet.common.persistence.template.dao.CourseVideoMapper;
import com.example.worknet.common.persistence.affair.video.serivce.CourseVideoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.worknet.common.persistence.template.modal.User;
import com.example.worknet.common.persistence.template.modal.VideoWatched;
import com.example.worknet.core.utils.FileToolsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 课程视频表 服务实现类
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@Service
public class CourseVideoServiceImpl extends ServiceImpl<CourseVideoMapper, CourseVideo> implements CourseVideoService {

    /**
     * 获取课程视频目录
     * @param cid
     * @return
     */
    @Override
    public List<HashMap<String,Object>> getCourseVideoMenu(long cid,long uid){
        List<CourseIndex> courseIndices = courseIndexService.selectList(new EntityWrapper<CourseIndex>().eq("course_id",cid));
        List<HashMap<String,Object>> list = new ArrayList<>();
        HashMap<String, Object> mapC = new HashMap<>();
        List<HashMap<String,Object>> menu = new ArrayList<>();
        int chapter = 1;
        int i = 0;
        while(i < courseIndices.size()){
            CourseIndex courseIndex = courseIndices.get(i);
            if(courseIndex.getScale()==1){
                mapC = new HashMap<>();
                menu = new ArrayList<>();
                chapter = courseIndex.getIndexOrder();
                mapC.put("title", String.format("第%d章 %s", chapter, courseIndex.getIndexTitle()));
                i++;
            }else{
                do {
                    courseIndex = courseIndices.get(i);
                    HashMap<String,Object> mapV = new HashMap<>();
                    mapV.put("title",String.format("第%d章第%d节 %s", chapter, courseIndex.getIndexOrder(), courseIndex.getIndexTitle()));
                    CourseVideo courseVideo = this.selectOne(new EntityWrapper<CourseVideo>().eq("course_index_id",courseIndex.getId()));
                    mapV.put("vid",courseVideo.getId());
                    VideoWatched videoWatched = videoWatchedService.selectOne(new EntityWrapper<VideoWatched>().eq("video_id",courseVideo.getId()).eq("user_id",uid));
                    if(videoWatched == null)
                        mapV.put("progress","0%");
                    else
                        mapV.put("progress",videoWatched.getVidelWatchedLength()+"%");
                    mapV.put("length",String.format("%02d", courseVideo.getVideoLen()/60)+":"+String.format("%02d", courseVideo.getVideoLen()%60));
                    menu.add(mapV);
                    i++;
                } while(i < courseIndices.size() && courseIndices.get(i).getScale() == 2);
            }
            if (i == courseIndices.size() || courseIndices.get(i).getScale() == 1){
                mapC.put("subMenu",menu);
                list.add(mapC);
            }
        }
        return list;
    }

    /**
     * 获取课程视频
     * @param vId
     * @return
     */
    @Override
    public Resource getCourseVideo(long vId, String strDirPath) {
        CourseVideo courseVideo = super.selectById(vId);
        if(courseVideo==null)
            throw new RuntimeException();
        String filePath = Const.FILE_PATH + courseVideo.getVideoPath();
        strDirPath = strDirPath+"WEB-INF"+ Const.FILE_SEPARATOR+"classes"+Const.FILE_SEPARATOR+"static"+Const.FILE_SEPARATOR+"upload";
        FileToolsUtil.fileToUpload(strDirPath,filePath);
        return resourceLoader.getResource("file:" + strDirPath + Const.FILE_SEPARATOR + filePath.substring(filePath.lastIndexOf(Const.FILE_SEPARATOR)+1));
    }

    @Autowired
    private CourseIndexService courseIndexService;

    @Autowired
    private VideoWatchedService videoWatchedService;

    @Autowired
    private final ResourceLoader resourceLoader;

    @Autowired
    public CourseVideoServiceImpl(ResourceLoader resourceLoader){
        this.resourceLoader = resourceLoader;
    }
}
