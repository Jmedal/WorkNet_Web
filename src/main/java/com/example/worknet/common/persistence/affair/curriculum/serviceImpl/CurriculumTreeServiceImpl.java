package com.example.worknet.common.persistence.affair.curriculum.serviceImpl;

import com.example.worknet.common.persistence.affair.curriculum.serivce.CurriculumService;
import com.example.worknet.common.persistence.template.modal.CurriculumTree;
import com.example.worknet.common.persistence.template.dao.CurriculumTreeMapper;
import com.example.worknet.common.persistence.affair.curriculum.serivce.CurriculumTreeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 课程树表 服务实现类
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@Service
public class CurriculumTreeServiceImpl extends ServiceImpl<CurriculumTreeMapper, CurriculumTree> implements CurriculumTreeService {

    /**
     * 从数据库中提取出科目树；
     * 以Map<Long,Object>的形式返回；
     * Map<Long,Object>   Long:id号  /  Object:实体对象Course Or Map对象,即Map<Long,Object>）
     * @return
     */
    @Override
    public Map getCurricumTree(){
        /**
         * 设计算法；
         * 从数据库中提取出科目树；
         * 以Map<Long,Object>的形式返回；
         * （Map<Long,Object>   Long:id号  /  Object:实体对象Course Or Map对象,即Map<Long,Object>）（具体看前端能处理的数据结构而定）
         */
        return null;
    }

    @Autowired
    private CurriculumTreeService curriculumTreeService;

    @Autowired
    private CurriculumService curriculumService;
}
