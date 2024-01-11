package com.blogs.dashboard;

import com.blogs.dashboard.Filter.gatewayfilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DashboardApplication {
	public static void main(String[] args) {
		SpringApplication.run(DashboardApplication.class, args);
		System.out.println("DashBoard is running");
	}
	@Bean
	public FilterRegistrationBean getFilter() {

		FilterRegistrationBean filterReg= new FilterRegistrationBean();
		filterReg.setFilter(new gatewayfilter());
		filterReg.addUrlPatterns("/addBlogs");
		return filterReg;
	}
}
