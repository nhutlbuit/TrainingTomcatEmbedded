package com.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.training.model.TrainingClass;

@Api(tags = "Training Class")
@RepositoryRestResource()
public interface TrainingClassRepository extends JpaRepository<TrainingClass, Long> {

	@ApiOperation("Find by Class Code ")
	@RestResource(path = "byClassCode")
	List<TrainingClass> findByClassCodeIgnoreCaseContains(@Param("classCode") String classCode);
}
