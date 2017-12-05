package com.yang;

import com.yang.interceptor.UserInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Yyang
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@MapperScan("com.yang.dao")
public class MtimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MtimeApplication.class, args);
	}

	@Configuration
	static class WebMvcConfigurer extends WebMvcConfigurerAdapter{
		@Override
		public void addInterceptors(InterceptorRegistry registry) {
			//用户评论拦截器
			registry.addInterceptor(new UserInterceptor())
					.addPathPatterns("/tomy","/remark/add","/admin","/admin-remark","/admin-remark");
		}
	}
}
