package com.training.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "COURSE")
@Data
public class Course extends AbstractEntity implements Serializable {


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
	private String courseName;
	
	@Column(name = "COURSE_CODE", length = 20, unique = true, nullable = false)
	private String courseCode;
	
	@Column(name = "QALF_SCORE", nullable = true)
	private  Double qualifiedScore;
	
}
