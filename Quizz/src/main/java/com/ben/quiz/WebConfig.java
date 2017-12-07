package com.ben.quiz;

import com.ben.quiz.domain.common.bean.handler.QuizErrorPageRegistrar;
import com.ben.quiz.domain.common.util.ResourceUtil;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ErrorPageRegistrar;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.ErrorPageFilter;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import javax.persistence.*;
import javax.sql.DataSource;
import java.util.Locale;


@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"com.ben.quiz.service",
        "com.ben.quiz.domain.model",
        "com.ben.quiz.domain.dto",
        "com.ben.quiz.domain.common",
        "com.ben.quiz.domain.repository.interfaces",
        "com.ben.quiz.controller"
})
public class WebConfig extends WebMvcConfigurerAdapter {

//
//    @BeaninModel
//    public TomcatEmbeddedServletContainerFactory tomcatFactory() {
//        return new TomcatEmbeddedServletContainerFactory() {
//            @Override
//            protected TomcatEmbeddedServletContainer getTomcatEmbeddedServletContainer(
//                    Tomcat tomcat) {
//                tomcat.enableNaming();
//                return super.getTomcatEmbeddedServletContainer(tomcat);
//            }
//            @Override
//            protected void postProcessContext(Context context) {
//                ContextResource resource = new ContextResource();
//                ;
//                resource.setName("jdbc/quizsystem");
//                resource.setType(DataSource.class.getName());
//                resource.setProperty("driverClassName", ResourceUtil.getProperty("application.properties","spring.datasource.driver-class-name"));
//                resource.setProperty("url", ResourceUtil.getProperty("application.properties","spring.datasource.url"));
//                context.getNamingResources().addResource(resource);
//            }
//        };
//    }
    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        source.registerCorsConfiguration("/**", config);
        final FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }

    @Bean
    public WebMvcConfigurer mvcConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("GET", "PUT", "POST", "GET", "OPTIONS", "DELETE");
            }
        };
    }


    // This is config for web - start
    @Bean
    public InternalResourceViewResolver resolver() {
        InternalResourceViewResolver vr = new InternalResourceViewResolver();
        vr.setPrefix("/WEB-INF/views/");
        vr.setSuffix(".jsp");
        vr.setViewClass(JstlView.class);
        return vr;
    }

    @Bean(name = "messageSource")
    public MessageSource getMessageResource() {
        ReloadableResourceBundleMessageSource messageResource = new ReloadableResourceBundleMessageSource();
        messageResource.setBasename("classpath:quizMessage");
        messageResource.setDefaultEncoding("UTF-8");
        return messageResource;
    }

    @Bean(name = "localeResolver")
    public LocaleResolver getLocaleResolver() {
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setCookieDomain("quizLocaleCookie");
        resolver.setDefaultLocale(new Locale(""));
        resolver.setCookieMaxAge(360 * 60);
        return resolver;
    }

    @Bean
    public ErrorPageFilter errorPageFilter() {
        return new ErrorPageFilter();
    }

    @Bean
    public FilterRegistrationBean disableSpringBootErrorFilter(ErrorPageFilter filter) {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(filter);
        filterRegistrationBean.setEnabled(false);
        return filterRegistrationBean;
    }

    // Session
    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }

    /**
     * Configure TilesConfigurer.
     */
    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions("/WEB-INF/config/tiles.xml");
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }

    /**
     * Configure ViewResolvers to deliver preferred views.
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        TilesViewResolver viewResolver = new TilesViewResolver();
        registry.viewResolver(viewResolver);
    }

    // Config for handle resources (css, img, js, ..etc.)
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // New style
        registry.addResourceHandler("/css/**", "/fonts/**", "/img/**", "/js/**", "/scss/**")
                .addResourceLocations("/WEB-INF/resources/css/", "/WEB-INF/resources/fonts/", "/WEB-INF/resources/img/",
                        "/WEB-INF/resources/img/", "/WEB-INF/resources/js/", "/WEB-INF/resources/scss/")
                .resourceChain(true);
        super.addResourceHandlers(registry);
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver getMultipartResolver() {
        return new CommonsMultipartResolver();
    }

    // This is config for web - end
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    /**
     * Locale resolver.
     *
     * @return the session locale resolver
     */
    @Bean
    public SessionLocaleResolver sessionLocaleResolver() {
        SessionLocaleResolver resolver = new SessionLocaleResolver();
        resolver.setDefaultLocale(Locale.ENGLISH);
        return resolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("locale");
        interceptor.setParamName("lang");
        registry.addInterceptor(localeChangeInterceptor()).addPathPatterns("/*");
    }

    @Bean
    public ErrorPageRegistrar errorPageRegistrar() {
        return new QuizErrorPageRegistrar();
    }

    @Bean
    @ResponseStatus(HttpStatus.NOT_FOUND)  // 404
    @ExceptionHandler(DataIntegrityViolationException.class)
    public String handleConflict() {
        return "error";
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

}

