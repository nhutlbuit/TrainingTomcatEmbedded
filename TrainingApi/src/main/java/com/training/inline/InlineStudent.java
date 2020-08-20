package com.training.inline;

import com.training.model.Student;
import com.training.model.TrainingClass;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "InlineStudent", types = { Student.class })
public interface InlineStudent {

	public TrainingClass getTrainingClass();
	public String getStudentCode();
	public String getAddress();
	public String getPhoneNumber();
	public java.util.Date getDateOfBirth();
	public String getLastName();
	public String getMiddleName();
	public String getFirstName();
	public long getId();
	@Value("#{(target.lastName + ' ' + (target.middleName == null || target.middleName == ''? '' : target.middleName + ' ') + target.firstName)}")
	String getFullName();

}