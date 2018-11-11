package com.training.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TRAINING_CLASS")
public class TrainingClass extends AbstractEntity{

	/**
	 * 
	 */
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
	//@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "trainingClass", fetch = FetchType.LAZY, targetEntity = Student.class)
	List<Student> students;
	
	@Column(name = "REF_TEACHER_CODE", length = 20)
	private String refTeacherCode;
	
	//@Fetch(FetchMode.JOIN)
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "REF_TEACHER_CODE", referencedColumnName = "TEACHER_CODE", 
	insertable = false, updatable = false)
	private Teacher teacherRef;
	
	@Column(name = "REF_COURSE_CODE", length = 20)
	private String refCourseCode;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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
	 * @return the students
	 */
	public List<Student> getStudents() {
		return students;
	}

	/**
	 * @param students the students to set
	 */
	public void setStudents(List<Student> students) {
		this.students = students;
	}

	/**
	 * @return the refTeacherCode
	 */
	public String getRefTeacherCode() {
		return refTeacherCode;
	}

	/**
	 * @param refTeacherCode the refTeacherCode to set
	 */
	public void setRefTeacherCode(String refTeacherCode) {
		this.refTeacherCode = refTeacherCode;
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
	 * @return the refCourseCode
	 */
	public String getRefCourseCode() {
		return refCourseCode;
	}

	/**
	 * @param refCourseCode the refCourseCode to set
	 */
	public void setRefCourseCode(String refCourseCode) {
		this.refCourseCode = refCourseCode;
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
