package com.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.training.model.TrainingClass;
import com.training.model.TrainingClassTest;

@Api(tags = "Training Class")
@RepositoryRestResource(collectionResourceRel = "TrainingClassTest", path = "TrainingClassTest") 
public interface TrainingClassRepositoryTest extends JpaRepository<TrainingClassTest, Long> {

	@ApiOperation("Find by Class Code ")
	@RestResource(path = "byClassCode")
	List<TrainingClassTest> findByClassCodeIgnoreCaseContains(@Param("classCode") String classCode);
}
