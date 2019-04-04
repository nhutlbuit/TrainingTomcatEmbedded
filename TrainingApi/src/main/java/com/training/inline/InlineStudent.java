package com.training.inline;

import com.training.model.Student;
import com.training.model.TrainingClass;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "InlineStudent", types = { Student.class })
public interface InlineStudent {

	public TrainingClass getTrainingClass();
	public String getStudentCode();
	public String getAddress();
	public Integer getPhoneNumber();
	public java.util.Date getDateOfBirth();
	public String getLastName();
	public String setMiddleName();
	public String getFirstName();

}