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
	@SequenceGenerator(name = "studentIdSeq", sequenceName = "SEQ_STUDENT_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentIdSeq")
	@Column(name = "ID", unique = true, nullable = false, precision = 10, scale = 0)
	private long id;
	
	@Column(name = "STUDENT_CODE", length = 20)
	private String studentCode;
	
	@Column(name = "REF_CLASS_CODE", length = 20)
	private String classCode;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name = "REF_CLASS_CODE", referencedColumnName = "CLASS_CODE", nullable=true, 
	insertable = false, updatable = false)
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
	private Integer phoneNumber;
	
	@Column(name = "ADDRESS", length = 100)
	private String address;

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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the midlename
	 */
	public String getMidlename() {
		return middleName;
	}

	/**
	 * @param midlename the midlename to set
	 */
	public void setMidlename(String midlename) {
		this.middleName = midlename;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastName;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastName = lastname;
	}

	/**
	 * @return the dateOfBirth
	 */
	public java.util.Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(java.util.Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the phoneNumber
	 */
	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	@Transient
	public String getFullName() {
		return String.join(" ", this.getLastname(), this.getMidlename(), this.getFirstName());
	}

	/**
	 * @return the studentCode
	 */
	public String getStudentCode() {
		return studentCode;
	}

	/**
	 * @param studentCode the studentCode to set
	 */
	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	/**
	 * @return the trainingClass
	 */
	public TrainingClass getTrainingClass() {
		return trainingClass;
	}

	/**
	 * @param trainingClass the trainingClass to set
	 */
	public void setTrainingClass(TrainingClass trainingClass) {
		this.trainingClass = trainingClass;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
