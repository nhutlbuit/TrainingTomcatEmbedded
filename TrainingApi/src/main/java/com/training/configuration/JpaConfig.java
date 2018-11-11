package com.training.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.training.model.AbstractEntity;


/**
 * @author LBN JPA Configuration for Training service
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.training.repository")
@EnableTransactionManagement
@EntityScan({ "com.training.model"})
//@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaConfig {
	@Bean
	@Profile("h2")
	ServletRegistrationBean h2servletRegistration() {
		ServletRegistrationBean registrationBean = new ServletRegistrationBean();
		registrationBean.addUrlMappings("/h2console/*");
		return registrationBean;
	}
	
	 @Bean
	 public AbstractEntity initAbstractEntity(){
		return new AbstractEntity();
	 }
	
/*	 @Bean
	 public AuditorAware<String> auditorProvider() {
	    return new AuditorAwareImpl();
	 }*/
}
