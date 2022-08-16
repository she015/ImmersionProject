package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.demo" })
public class WebConfig extends WebMvcConfigurerAdapter {
	

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		// Register admin interceptor with single path patterns
		registry.addInterceptor(new AdminInterceptor())
		.addPathPatterns("/useraccount/**");
		
//		// Register UserInterceptor  with multiple path patterns
//		registry.addInterceptor(new UserInterceptor())
//		.addPathPatterns("/user/*");

//		// Register Guest interceptor with multiple path patterns
//		registry.addInterceptor(new GuestInterceptor())
//		.addPathPatterns(new String[] { "/test", "/user/*" });

	}

	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
}