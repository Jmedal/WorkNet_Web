package com.example.worknet.common.constant;

/**
 * @author YunJieJiang123
 * @since 2018-12-03
 */
public interface Const {

    /**
     * 系统默认的管理员密码
     */
    String DEFAULT_PWD = "111111";

    /**
     * 管理员角色的名字
     */
    String ADMIN_NAME = "administrator";

    /**
     * 管理员id
     */
    Integer ADMIN_ID = 1;

    /**
     * 超级管理员角色id
     */
    Integer ADMIN_ROLE_ID = 1;

    /**
     * 接口文档的菜单名
     */
    String API_MENU_NAME = "接口文档";

    /**
     * 上传文件路径
     */
    String IMAGE_SAVE_PATH_Windows=System.getProperty("user.dir")+"\\src\\main\\resources\\static\\images\\temp";

    /**
     * linux上传文件目录
     */
     String IMAGE_SAVE_PATH_LINUX=System.getProperty("user.dir")+"/src/main/resources/static/images/temp";

    /**
     * 系统文件分隔符
     */
     String FILE_SEPARATOR = System.getProperty("file.separator");

    /**
     * 获取操作系统类型
     */
     String os = System.getProperty("os.name");

    /**
     * 获取当前存储路径
     */
     String FILE_PATH = Const.os.toLowerCase().indexOf("win")!=-1?Const.IMAGE_SAVE_PATH_Windows:Const.IMAGE_SAVE_PATH_LINUX;

    /**
     * 学习者头像文件夹
     */
    String HEAD_PATH = "avatar";

    /**
     * 课程预览图片文件夹
     */
    String COURSE_PICTURE_PATH = "course_picture";

    /**
     * 课程视频文件夹
     */
    String COURSE_VIEW_PATH = "course_view";

    /**
     * 问题图片文件夹
     */
    String PICTURE_PATH = "picture";

    /**
     * 回答图片文件夹
     */
    String FILE_SHARE = "answer";
}
