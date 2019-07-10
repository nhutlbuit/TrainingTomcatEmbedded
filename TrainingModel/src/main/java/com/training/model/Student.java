package com.training.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "STUDENT")
public class Student extends AbstractEntity implements Serializable, Cloneable {

	/**
	 * 
	 */
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


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public TrainingClass getTrainingClass() {
		return trainingClass;
	}

	public void setTrainingClass(TrainingClass trainingClass) {
		this.trainingClass = trainingClass;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public java.util.Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(java.util.Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
