package com.example.worknet.config.tomcat;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;


/**
 * 使用tomcat配置
 *
 * @version
 * @author
 *
 */
@Configuration
@ConfigurationProperties(prefix = "tomcat")
public class TomcatConfig {

    private String port;

    private String acceptorThreadCount;

    private String minSpareThreads;

    private String maxSpareThreads;

    private String maxThreads;

    private String maxConnections;

    private String protocol;

    private String redirectPort;

    private String compression;

    private String connectionTimeout;


    private String MaxFileSize;

    private String MaxRequestSize;

    @Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addConnectorCustomizers(new GwsTomcatConnectionCustomizer());
        return tomcat;
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //  单个数据大小
        factory.setMaxFileSize(MaxFileSize); // KB,MB
        /// 总上传数据大小
        factory.setMaxRequestSize(MaxRequestSize);
        return factory.createMultipartConfig();
    }

    /**
     *
     * 默认http连接
     *
     * @version
     * @author liuyi  2016年7月20日 下午7:59:41
     *
     */
    public class GwsTomcatConnectionCustomizer implements TomcatConnectorCustomizer {

        public GwsTomcatConnectionCustomizer() {
        }

        @Override
        public void customize(Connector connector) {
            connector.setPort(Integer.valueOf(port));
            connector.setAttribute("connectionTimeout", connectionTimeout);
            connector.setAttribute("acceptorThreadCount", acceptorThreadCount);
            connector.setAttribute("minSpareThreads", minSpareThreads);
            connector.setAttribute("maxSpareThreads", maxSpareThreads);
            connector.setAttribute("maxThreads", maxThreads);
            connector.setAttribute("maxConnections", maxConnections);
            connector.setAttribute("protocol", protocol);
            connector.setAttribute("redirectPort", "redirectPort");
            connector.setAttribute("compression", "compression");
        }
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getAcceptorThreadCount() {
        return acceptorThreadCount;
    }

    public void setAcceptorThreadCount(String acceptorThreadCount) {
        this.acceptorThreadCount = acceptorThreadCount;
    }

    public String getMinSpareThreads() {
        return minSpareThreads;
    }

    public void setMinSpareThreads(String minSpareThreads) {
        this.minSpareThreads = minSpareThreads;
    }

    public String getMaxSpareThreads() {
        return maxSpareThreads;
    }

    public void setMaxSpareThreads(String maxSpareThreads) {
        this.maxSpareThreads = maxSpareThreads;
    }

    public String getMaxThreads() {
        return maxThreads;
    }

    public void setMaxThreads(String maxThreads) {
        this.maxThreads = maxThreads;
    }

    public String getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(String maxConnections) {
        this.maxConnections = maxConnections;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getRedirectPort() {
        return redirectPort;
    }

    public void setRedirectPort(String redirectPort) {
        this.redirectPort = redirectPort;
    }

    public String getCompression() {
        return compression;
    }

    public void setCompression(String compression) {
        this.compression = compression;
    }

    public String getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(String connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public String getMaxFileSize() {
        return MaxFileSize;
    }

    public void setMaxFileSize(String maxFileSize) {
        MaxFileSize = maxFileSize;
    }

    public String getMaxRequestSize() {
        return MaxRequestSize;
    }

    public void setMaxRequestSize(String maxRequestSize) {
        MaxRequestSize = maxRequestSize;
    }
}
