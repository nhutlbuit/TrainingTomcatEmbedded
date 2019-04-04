package com.training.configuration;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.TimeZone;

import javax.servlet.Filter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

@Configuration
@EnableCaching
public class ApplicationConfig {
	@Bean
	public Filter characterEncodingFilter() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		return characterEncodingFilter;
	}

	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.US); // Set default Locale as US
		return slr;
	}

	@Bean
	public ObjectMapper jsonObjectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setTimeZone(TimeZone.getDefault());
		SimpleModule module = new SimpleModule("DoubleSerializer");
		module.addSerializer(Double.class, new DoubleSerializer());
		mapper.registerModule(module); 
		return mapper;
	}

}

class DoubleSerializer extends JsonSerializer<Double> {
	@Override
	public void serialize(Double value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		String realString = new BigDecimal(value).toPlainString();
		jgen.writeString(realString);
	}

	@Bean
	public MessageSource messageSource() {
	    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	    messageSource.setBasename("classpath:messages");
	    messageSource.setCacheSeconds(10); //reload messages every 10 seconds
	    return messageSource;
	}
}