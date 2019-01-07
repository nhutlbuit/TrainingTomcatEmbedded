package com.training.repository.inline;

import java.util.List;

import org.springframework.data.rest.core.config.Projection;

import com.training.model.Course;
import com.training.model.Student;
import com.training.model.Teacher;
import com.training.model.TrainingClass;

@Projection(name = "InlineTrainingClass", types = { TrainingClass.class })
public interface InlineTrainingClass {
	
	public long getId();
	public String getClassCode();
	public String getClassName();
	public java.util.Date getFromDate() ;
	public java.util.Date getToDate();
	public Double getScore();
	public List<Student> getStudents();
	public Teacher getTeacherRef();
	public Course getCourseRef();

}