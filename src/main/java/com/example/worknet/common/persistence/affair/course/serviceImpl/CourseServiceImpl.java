package com.example.worknet.common.persistence.affair.course.serviceImpl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.worknet.common.constant.Const;
import com.example.worknet.common.constant.CourseConst;
import com.example.worknet.common.persistence.affair.course.serivce.*;
import com.example.worknet.common.persistence.affair.video.serivce.CourseVideoService;
import com.example.worknet.common.persistence.template.modal.Course;
import com.example.worknet.common.persistence.template.dao.CourseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.worknet.common.persistence.template.modal.CourseIndex;
import com.example.worknet.common.persistence.template.modal.CourseVideo;
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
 * 课程表 服务实现类
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-30
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    /**
     * 添加课程
     * @param course
     * @return
     */
    @Override
    public boolean insertCourse(Course course){
        return super.insert(course);
    }

    /**
     * 更新课程信息
     * @param course
     * @return
     */
    @Override
    public boolean updateCourse(Course course){
        return super.updateById(course);
    }

    /**
     * 获取课程基本信息
     * @param cid
     * @return
     */
    @Override
    public HashMap<String,Object> getCourseInfo(long cid){
        return courseMapper.getCourseInfo(cid);
    }

    /**
     * 获取筛选的课程列表信息
     * @param page
     * @param type
     * @return
     */
    @Override
    public Page<HashMap<String,Object>> getCoursePage(Page<HashMap<String, Object>> page, Integer type, String keyword){
        if(type.equals(CourseConst.COURSE_NEW)){
            return page.setRecords(courseMapper.getNewCoursePage(page,keyword));
        }
        else if (type.equals(CourseConst.COURSE_STAR)){
            return page.setRecords(courseMapper.getStarCoursePage(page,keyword));
        }
        else if (type.equals(CourseConst.COURSE_MOST)){
            return page.setRecords(courseMapper.getStudiedCoursePage(page,keyword));
        }
        else{
            return page.setRecords(courseMapper.getDefaultCoursePage(page,keyword));
        }
    }

    /**
     * 获取课程目录
     * @param cid
     * @return
     */
    @Override
    public List<HashMap<String,Object>> getCourseMenu(long cid){
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
                    mapV.put("vid",courseVideoService.selectOne(new EntityWrapper<CourseVideo>().eq("course_index_id",courseIndex.getId())).getId());
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
     * 获取课程预览图片
     * @param cid
     * @param strDirPath
     * @return
     */
    @Override
    public Resource getCoursePicture(long cid, String strDirPath) {
        Course course = super.selectById(cid);
        if(course==null)
            throw new RuntimeException();
        String filePath = course.getPicturePath();
        strDirPath = strDirPath+"WEB-INF"+ Const.FILE_SEPARATOR+"classes"+Const.FILE_SEPARATOR+"static"+Const.FILE_SEPARATOR+"upload";
        FileToolsUtil.fileToUpload(strDirPath,filePath);
        return resourceLoader.getResource("file:" + strDirPath + Const.FILE_SEPARATOR + filePath.substring(filePath.lastIndexOf(Const.FILE_SEPARATOR)+1));
    }

    @Autowired
    private  CourseMapper courseMapper;

    @Autowired
    private CourseClickService courseClickService;

    @Autowired
    private CourseCommentService courseCommentService;

    @Autowired
    private CourseIndexService courseIndexService;

    @Autowired
    private CourseStudiedService courseStudiedService;

    @Autowired
    private CourseVideoService courseVideoService;

    @Autowired
    private final ResourceLoader resourceLoader;

    @Autowired
    public CourseServiceImpl(ResourceLoader resourceLoader){
        this.resourceLoader = resourceLoader;
    }
}
