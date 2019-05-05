package com.example.worknet.common.persistence.affair.curriculum.serivce;

import com.example.worknet.common.persistence.template.modal.Curriculum;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * <p>
 * 科目表 服务类
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
public interface CurriculumService extends IService<Curriculum> {

    Map getCurrilumTreeMap();

}
