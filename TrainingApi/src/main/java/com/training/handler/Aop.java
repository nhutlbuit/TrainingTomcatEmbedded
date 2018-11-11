package com.training.handler;

import javax.annotation.Resource;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import com.training.model.AbstractEntity;


@Component
@RepositoryEventHandler(AbstractEntity.class)
@Aspect
public class Aop {

	@Resource
	@Autowired
	AbstractEntity abstractEntity;
	
	@Before("execution(* vn.com.school.training.service.impl.*.*(..))")
	public void beforeSaveData() {
		abstractEntity.setCreatedBy("created1");
		abstractEntity.setUpdatedBy("updated1");
	}
	

}