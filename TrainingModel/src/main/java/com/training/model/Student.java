package com.training.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "STUDENT")
@Data
public class Student extends AbstractEntity implements Serializable, Cloneable {

	private static final long serialVersionUID = 8208045971608928281L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false, precision = 10, scale = 0)
	private long id;
	
	@Column(name = "STUDENT_CODE", length = 20)
	private String studentCode;
	
	@Column(name = "REF_CLASS_CODE", length = 20)
	private String classCode;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name = "REF_CLASS_CODE", referencedColumnName = "CLASS_CODE", nullable = true, insertable = false, updatable = false)
	private TrainingClass trainingClass;

	@Column(name = "FIRST_NAME", length = 20)
	private String firstName;
	
	@Column(name = "MIDDLE_NAME", length = 20)
	private String middleName;
	
	@Column(name = "LAST_NAME", length = 20)
	private String lastName;
	
	@Column(name = "DOB")
	@Temporal(TemporalType.DATE)
	private java.util.Date dateOfBirth;
	
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
	
	@Column(name = "ADDRESS", length = 100)
	private String address;

}
