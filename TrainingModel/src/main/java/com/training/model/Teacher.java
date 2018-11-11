package com.training.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "TEACHER")
public class Teacher extends AbstractEntity  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8208045971608928281L;

	@Id
/*	@SequenceGenerator(name = "teacherIdSeq", sequenceName = "SEQ_TEACHER_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacherIdSeq")*/
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false, precision = 10, scale = 0)
	private long id;
	
	@Column(name = "TEACHER_CODE", length = 20)
	private String teacherCode;

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

	@Transient
	public String getFullName() {
		return String.join(" ", this.getLastName(), this.getMiddleName(), this.getFirstName());
	}

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
	 * @return the teacherCode
	 */
	public String getTeacherCode() {
		return teacherCode;
	}

	/**
	 * @param teacherCode the teacherCode to set
	 */
	public void setTeacherCode(String teacherCode) {
		this.teacherCode = teacherCode;
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

	

	
	
}
