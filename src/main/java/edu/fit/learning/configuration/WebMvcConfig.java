package edu.fit.learning.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by virus on 03/13/16.
 */

@Configuration
@EnableAutoConfiguration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public WebMvcConfigurerAdapter initAdapter(){
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/angular/**").addResourceLocations("/WEB-INF/assets/angular/");
                registry.addResourceHandler("/app/**").addResourceLocations("/WEB-INF/assets/app/");
                registry.addResourceHandler("/bootstrap/**").addResourceLocations("/WEB-INF/assets/bootstrap/");
                registry.addResourceHandler("/img/**").addResourceLocations("/WEB-INF/assets/img/");
                registry.addResourceHandler("/scripts/**").addResourceLocations("/WEB-INF/assets/scripts/");
                registry.addResourceHandler("/styles/**").addResourceLocations("/WEB-INF/assets/styles/");
                registry.addResourceHandler("/**").addResourceLocations("/WEB-INF/views/");
            }
        };
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setSuffix(".html");
        return resolver;
    }

    ServletRegistrationBean h2servimletRegistration() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.addUrlMappings("/console/*");
        return servletRegistrationBean;
    }
}
