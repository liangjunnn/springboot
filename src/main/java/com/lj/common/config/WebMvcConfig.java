package com.lj.common.config;

import com.lj.common.interceptor.TestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author : liangjun
 * @ClassName : WebJMvcConfig
 * @Description :
 * @Date : 2019/11/22 9:48
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    //测试拦截器
    private TestInterceptor testInterceptor;

    @Autowired
    public WebMvcConfig(TestInterceptor testInterceptor) {
        this.testInterceptor = testInterceptor;
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(testInterceptor).addPathPatterns("/**").excludePathPatterns("/test/queryUserInfo");
//        super.addInterceptors(registry);
    }
}
