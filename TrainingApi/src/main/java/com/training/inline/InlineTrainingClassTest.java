package com.training.inline;

import com.training.model.Course;
import com.training.model.Teacher;
import com.training.model.TrainingClassTest;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "InlineTrainingClassTest", types = { TrainingClassTest.class })
public interface InlineTrainingClassTest {
	
	long getId();
	String getClassCode();
	String getClassName();
	java.util.Date getFromDate() ;
	java.util.Date getToDate();
	Double getScore();
	Teacher getTeacherRef();
	Course getCourseRef();

}