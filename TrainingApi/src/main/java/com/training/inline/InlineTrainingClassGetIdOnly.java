package com.training.inline;

import org.springframework.data.rest.core.config.Projection;

import com.training.model.TrainingClass;

@Projection(name = "InlineTrainingClassGetIdOnly", types = { TrainingClass.class })
public interface InlineTrainingClassGetIdOnly {
	
	public long getId();
	public String getClassCode();
	public String getClassName();
	

}