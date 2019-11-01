package com.training.model;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TRAINING_CLASS")
@Data
public class TrainingClass extends AbstractEntity implements Serializable{

	private static final long serialVersionUID = 7189872751297163713L;

	@Id
	@SequenceGenerator(name = "classIdSeq", sequenceName = "SEQ_CLASS_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "classIdSeq")
	@Column(name = "ID", unique = true, nullable = false, precision = 10, scale = 0)
	private long id;

	@Column(name = "CLASS_NAME", length = 50)
	private String className;
	
	@Column(name = "CLASS_CODE", length = 20)
	private String classCode;
	
	@OrderBy("firstName desc")
	@OneToMany(mappedBy = "trainingClass", fetch = FetchType.LAZY, targetEntity = Student.class)
	List<Student> students;
	
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "REF_TEACHER_CODE", length = 20)
	private String refTeacherCode;
	
	@Fetch(FetchMode.SELECT)
	@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY, optional = false)
	@LazyToOne(value = LazyToOneOption.NO_PROXY)
	@JoinColumn(name = "REF_TEACHER_CODE", referencedColumnName = "TEACHER_CODE", insertable = false, updatable = false)
	private Teacher teacherRef;
	
	@Column(name = "REF_COURSE_CODE", length = 20)
	private String refCourseCode;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "REF_COURSE_CODE", referencedColumnName = "COURSE_CODE", insertable = false, 
	updatable = false)
	private Course courseRef;
	
	@Column(name = "FROM_DATE")
	@Temporal(TemporalType.DATE)
	private java.util.Date fromDate;
	
	@Column(name = "TO_DATE")
	@Temporal(TemporalType.DATE)
	private java.util.Date toDate;
	
	@Column(name = "SCORE")
	private Double score;
}
