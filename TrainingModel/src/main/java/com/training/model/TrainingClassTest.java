package com.training.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TRAINING_CLASS_TEST")
public class TrainingClassTest extends AbstractEntity implements Serializable{

	private static final long serialVersionUID = -7866462895714629393L;

	@Id
	@SequenceGenerator(name = "classIdSeq1", sequenceName = "SEQ_CLASS_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "classIdSeq1")
	@Column(name = "ID", unique = true, nullable = false, precision = 10, scale = 0)
	private long id;

	@Column(name = "CLASS_NAME", length = 50)
	private String className;
	
	@Column(name = "CLASS_CODE", length = 20)
	private String classCode;
	
	@Column(name = "REF_TEACHER_ID")
	private long refTeacherCode;

	@Fetch(FetchMode.SELECT)
	@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY, optional = true)
	@LazyToOne(value = LazyToOneOption.NO_PROXY)
	@JoinColumn(name = "REF_TEACHER_ID", referencedColumnName = "ID", insertable = false, updatable = false)
	@RestResource(exported = true)
	private Teacher teacherRef;
	
	@Column(name = "REF_COURSE_ID")
	private long refCourseId;
	
	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "REF_COURSE_ID", referencedColumnName = "ID", insertable = false, updatable = false)
	@RestResource(exported = false) /* Enabled to hibernate to know to export the resource */
	private Course courseRef;
	
	@Column(name = "FROM_DATE")
	@Temporal(TemporalType.DATE)
	private java.util.Date fromDate;
	
	@Column(name = "TO_DATE")
	@Temporal(TemporalType.DATE)
	private java.util.Date toDate;
	
	@Column(name = "SCORE")
	private Double score;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param className the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * @return the fromDate
	 */
	public java.util.Date getFromDate() {
		return fromDate;
	}

	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(java.util.Date fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * @return the toDate
	 */
	public java.util.Date getToDate() {
		return toDate;
	}

	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(java.util.Date toDate) {
		this.toDate = toDate;
	}

	/**
	 * @return the score
	 */
	public Double getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(Double score) {
		this.score = score;
	}

	/**
	 * @return the classCode
	 */
	public String getClassCode() {
		return classCode;
	}

	/**
	 * @param classCode the classCode to set
	 */
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}


	/**
	 * @return the teacherRef
	 */
	public Teacher getTeacherRef() {
		return teacherRef;
	}

	/**
	 * @param teacherRef the teacherRef to set
	 */
	public void setTeacherRef(Teacher teacherRef) {
		this.teacherRef = teacherRef;
	}

	/**
	 * @return the courseRef
	 */
	public Course getCourseRef() {
		return courseRef;
	}

	/**
	 * @param courseRef the courseRef to set
	 */
	public void setCourseRef(Course courseRef) {
		this.courseRef = courseRef;
	}

	
	
	
}
