package com.training.configuration;

import java.util.Arrays;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
// @Import({springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration.class})
@Import(SpringDataRestConfiguration.class)
public class SwaggerConfig extends WebMvcConfigurerAdapter {
	
	protected RequestMethod[] mainApiMethods = {RequestMethod.GET, RequestMethod.POST, 
			RequestMethod.PUT, RequestMethod.PATCH, RequestMethod.DELETE};

	 @Override
	 public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
	 }
	 
	@Bean
	public Docket kpiApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("teamKpi")
				.select()
				.apis(allowGetRequestHandlers())
				.paths(PathSelectors.ant("/training/**")).build()
				.apiInfo(metadata());
	}
	
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
        .groupName("full-hub-api").select()
        .apis(RequestHandlerSelectors.any())
        // .apis(RequestHandlerSelectors.basePackage("com.dxc.integral.springhub.rest.web")
        .paths(PathSelectors.any()).build();
        // .pathMapping("/api-docs");
    }
	
	@Bean
	public Docket defaultApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("JPA Auto Export APIs")
				.select()
				.apis(allowRequestHandlers(mainApiMethods))
				.apis(RequestHandlerSelectors.basePackage("com.training.repository"))
				.paths(PathSelectors.ant("/**"))
				.build().apiInfo(metadata());
	}
	
	@Bean
	public Docket customApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Custom Export APIs")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.training.controller"))
				.paths(PathSelectors.ant("/**"))
				.build().apiInfo(metadata());
	}
	
	@Bean
	public Docket allGetApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(allowGetRequestHandlers())
				.paths(PathSelectors.ant("/api/**")).build()
				.apiInfo(metadata());
	}
	
	@Bean
	public Docket agencyDevelopmentApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Development API")
				.select()
				.paths(Predicates.not(PathSelectors.ant("/error")))
				.paths(Predicates.not(PathSelectors.ant("/api/school")))
				.build().apiInfo(metadata());
	}

	private ApiInfo metadata() {
		return new ApiInfoBuilder().title("Development API Service")
				.description("REST API for Training resource").version("0.0.1-SNAPSHOT")
				.contact(new Contact("LBN Invidual", "http://www.lbn.com.vn", "nhutlbuit@gmail.com"))
				.build();
	}

	protected Predicate<RequestHandler> allowGetRequestHandlers() {
		return new Predicate<RequestHandler>() {
			@Override
			public boolean apply(RequestHandler input) {
				Set<RequestMethod> methods = input.supportedMethods();
				return methods.contains(RequestMethod.GET);
			}
		};
	}
	
	protected Predicate<RequestHandler> allowRequestHandlers(RequestMethod... httpMethods) {
		return new Predicate<RequestHandler>() {
			@Override
			public boolean apply(RequestHandler input) {
				Set<RequestMethod> methods = input.supportedMethods();
				return Arrays.asList(httpMethods).containsAll(methods);
			}
		};
	}
}
