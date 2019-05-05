package com.example.worknet.config.druid;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: YunJieJiang
 * @Date: Created in 14:37 2018/10/19 0019
 */
@Configuration
public class DruidConfig {

    private static final Logger log = LoggerFactory.getLogger(DruidConfig.class);

    @Bean
    public ServletRegistrationBean druidServlet() {
        log.info("init Druid Servlet Configuration ");
        //创建servlet注册实体
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new StatViewServlet());
        servletRegistrationBean.addUrlMappings("/druid/*");

        Map<String, String> initParameters = new HashMap<String, String>();
        //设置控制台管理用户
        initParameters.put("loginUsername", "admin");// 用户名
        initParameters.put("loginPassword", "admin");// 密码

        // 禁用HTML页面上的“Reset All”功能(是否可以重置数据)
        initParameters.put("resetEnable", "false");

        // IP白名单 (没有配置或者为空，则允许所有访问)
        initParameters.put("allow", "");

        // IP黑名单 (存在共同时，deny优先于allow)
        //initParameters.put("deny", "192.168.20.38");

        servletRegistrationBean.setInitParameters(initParameters);
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        //创建过滤器
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());

        //设置过滤器过滤路径
        filterRegistrationBean.addUrlPatterns("/*");

        //忽略过滤的形式
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");

        return filterRegistrationBean;
    }

}
