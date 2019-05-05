package com.example.worknet.common.persistence.affair.curriculum.serviceImpl;

import com.example.worknet.common.persistence.affair.curriculum.serivce.CurriculumCourseService;
import com.example.worknet.common.persistence.affair.curriculum.serivce.CurriculumTreeService;
import com.example.worknet.common.persistence.template.modal.Curriculum;
import com.example.worknet.common.persistence.template.dao.CurriculumMapper;
import com.example.worknet.common.persistence.affair.curriculum.serivce.CurriculumService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 科目表 服务实现类
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@Service
public class CurriculumServiceImpl extends ServiceImpl<CurriculumMapper, Curriculum> implements CurriculumService {

    /**
     * 获得科目树
     * @return
     */
    @Override
    public Map getCurrilumTreeMap(){
        return curriculumTreeService.getCurricumTree();
    }

    @Autowired
    private CurriculumService curriculumService;

    @Autowired
    private CurriculumCourseService curriculumCourseService;

    @Autowired
    private CurriculumTreeService curriculumTreeService;
}
