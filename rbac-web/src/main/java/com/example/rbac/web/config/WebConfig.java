package com.example.rbac.web.config;

import com.example.common.xss.JacksonXSSDeserializer;
import com.example.common.xss.WebXSSFilter;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * web相关配置
 *
 * @author Jack
 * @date 2020/04/25
 */
@Configuration
public class WebConfig {

    /**
     * 防止通过parameter传入XSS脚本
     * @return
     */
    @Bean
    public FilterRegistrationBean webXSSFilterBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        WebXSSFilter filter = new WebXSSFilter();
        registrationBean.setFilter(filter);
        List<String> urlPatterns = new ArrayList<>();
        urlPatterns.add("/*");
        registrationBean.setUrlPatterns(urlPatterns);
        return registrationBean;
    }

    /**
     * 防止通过body传入XSS脚本
     * @return
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonXSSCustomizer(){
        return jacksonObjectMapperBuilder ->
            jacksonObjectMapperBuilder.deserializerByType(String.class,new JacksonXSSDeserializer());
    }


    /**
     * 国际化解析器，默认中文
     *
     * @return
     */
    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver slr = new CookieLocaleResolver();
        slr.setCookieMaxAge(3600);
        slr.setDefaultLocale(Locale.CHINA);
        return slr;
    }

    /**
     * 配置语言切换拦截器
     *
     * @return
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            // 拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
                // 自定义语言切换参数，默认是locale
                localeChangeInterceptor.setParamName("lang");
                registry.addInterceptor(localeChangeInterceptor).addPathPatterns("/**");
            }
        };
    }

}

