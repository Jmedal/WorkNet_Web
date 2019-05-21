package com.example.worknet.config.mybatis;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
/**
 * @Author: YunJieJiang
 * @Date: Created in 14:39 2018/10/19 0019
 */
public class CodeGeneration {

    /**
     *
     * @Title: main
     * @Description: 代码生成器
     * @param args
     */
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("C:\\Users\\Medal姜总\\Desktop\\worknet\\worknet\\src\\main\\java");
        gc.setFileOverride(true);
        gc.setActiveRecord(false);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("YunJieJiang");// 作者

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/worknet");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setTablePrefix(new String[] { "sys_" });// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setInclude(new String[] {"sys_company"}); // 需要生成的表
//                 "sys_user",
//                "sys_curriculum",
//                "sys_course_video",
//                "sys_course",
//                "sys_course_comment",
//                "sys_curriculum_tree",
//                "sys_administrator",
//                "sys_curriculum_course",
//                "sys_teacher_info",
//                "sys_company",
//                "sys_video_discussion",
//                "sys_video_watched",
//                "sys_course_click",
//                "sys_course_index",
//                "sys_course_studied",
//                "sys_course_contest_option",
//                "sys_course_contest_question",
//                "sys_course_contest_score",
//                "sys_course_contest_user_answer",
//                "sys_company_contest",
//                "sys_company_contest_choice_option",
//                "sys_company_contest_question",
//                "sys_company_contest_result",
//                "sys_comany_contest_apply",
//                "sys_course_contest",
//                "sys_course_contest_result",
//                "sys_learner_info",
//                "sys_professtion",
//                "sys_profession_type",
//                "sys_course_recommend",
//                "sys_message"

        strategy.setSuperServiceClass(null);
        strategy.setSuperServiceImplClass(null);
        strategy.setSuperMapperClass(null);

        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.example.worknet.common.persistence");
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("serviceImpl");
        pc.setMapper("dao");
        pc.setEntity("modal");
        pc.setXml("mapping");
        mpg.setPackageInfo(pc);

        // 执行生成
        mpg.execute();

    }

}
