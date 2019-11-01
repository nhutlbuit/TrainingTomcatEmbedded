package com.training.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TEACHER")
@Data
public class Teacher extends AbstractEntity  implements Serializable{

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
}
