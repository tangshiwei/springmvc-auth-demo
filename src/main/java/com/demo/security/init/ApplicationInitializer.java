package com.demo.security.init;

import com.demo.security.config.ApplicactionConfig;
import com.demo.security.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 加载Spring容器
 */
public class ApplicationInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer {

    //applicationContext.xml
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ApplicactionConfig.class};
    }
    //spring-mvc.xml
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    //url mapping
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
