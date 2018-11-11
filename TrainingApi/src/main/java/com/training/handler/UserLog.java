package com.training.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import com.training.model.AbstractEntity;


/**
 * 
 * @author Nhut.le
 *
 */

@Component
@RepositoryEventHandler({AbstractEntity.class})
public class UserLog {
	
	
	@Autowired
	AbstractEntity abstractEntity;

	/**
	 * 
	 * @expectation Set Username logged to CreatedBy and UpdatedBy fields 
	 */
	@HandleBeforeCreate
	public void createdBy(AbstractEntity abstractEntity) {
		abstractEntity.setCreatedBy("created");
	}
	
	@HandleBeforeSave
	public void UpdatedBy(AbstractEntity abstractEntity) {
		abstractEntity.setUpdatedBy("updated");
	}
	
}
