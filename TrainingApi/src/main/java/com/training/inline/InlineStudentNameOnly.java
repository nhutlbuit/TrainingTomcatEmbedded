package com.training.inline;

import com.training.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "InlineStudentNameOnly", types = { Student.class })
public interface InlineStudentNameOnly {

	@Value("#{(target.lastName + ' ' + (target.middleName == null || target.middleName == ''? '' : target.middleName + ' ') + target.firstName)}")
	String getFullName();

}