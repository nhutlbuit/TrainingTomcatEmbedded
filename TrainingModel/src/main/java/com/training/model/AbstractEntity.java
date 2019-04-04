package com.training.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.training.common.util.DateUtils;

/**
 * 
 * @author NL
 *
 */

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AbstractEntity implements Serializable {

	private static final long serialVersionUID = 3470819715990404316L;

	@Column(name = "UPDT_DT", nullable = true, updatable = true)
	@JsonIgnore
	@UpdateTimestamp
	private Timestamp updatedDate;

	@Column(name = "UPDT_BY", nullable = true, updatable = true)
	@LastModifiedBy
	private String updatedBy;

	@Column(name = "CREAT_DT", nullable = true, updatable = false)
	@JsonIgnore
	@CreationTimestamp
	private Timestamp createdDate;

	@Column(name = "CREAT_BY", nullable = true, updatable = false)
	@CreatedBy
	private String createdBy;
	
//	@PrePersist
//	void createdAt() {
//		this.updatedDate = this.createdDate = DateUtils.getCurrentTimestamp();
//	}

	@PreUpdate
	void updatedAt() {
		this.updatedDate = DateUtils.getCurrentTimestamp();
	}
	
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

//	public Timestamp getUpdatedDate() {
//		return updatedDate;
//	}
//
//	public void setUpdatedDate(Timestamp updatedDate) {
//		this.updatedDate = updatedDate;
//	}

	public String getUpdatedBy() {
		return updatedBy;
	}

//	public Timestamp getCreatedDate() {
//		return createdDate;
//	}
//
//	public void setCreatedDate(Timestamp createdDate) {
//		this.createdDate = createdDate;
//	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
