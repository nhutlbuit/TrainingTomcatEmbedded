package com.training.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "COURSE")
public @Data class Course extends AbstractEntity implements Serializable {


	/**
	 * Hibernate does not support one-to-one and lazy loading.
		Workaround:
		Use one-to-many in parent and ono-to-one in child.
	 */
	private static final long serialVersionUID = 7560332713289109340L;


	@Id
	// @SequenceGenerator(name = "courseIdSeq", sequenceName = "SEQ_COURSE_ID", allocationSize = 1)
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "courseIdSeq")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false, precision = 10, scale = 0)
	private long id;


	@Column(name = "COURSE_NAME", length = 50)
	private @Getter @Setter String courseName;
	
	@Column(name = "COURSE_CODE", length = 20, unique = true, nullable = false)
	private @Getter @Setter String courseCode;
	
	@Getter @Setter
	@Column(name = "QALF_SCORE", nullable = true)
	private  Double qualifiedScore;

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
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * @return the courseCode
	 */
	public String getCourseCode() {
		return courseCode;
	}

	/**
	 * @param courseCode the courseCode to set
	 */
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	/**
	 * @return the qualifiedScore
	 */
	public Double getQualifiedScore() {
		return qualifiedScore;
	}

	/**
	 * @param qualifiedScore the qualifiedScore to set
	 */
	public void setQualifiedScore(Double qualifiedScore) {
		this.qualifiedScore = qualifiedScore;
	}
	
	
}
