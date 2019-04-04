package com.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.training.model.Teacher;

@Api(tags = "Teacher information")
@RepositoryRestResource()
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

	@ApiOperation("Find by FirstName  ")
	@RestResource(path = "byFirstName")
	List<Teacher> findByFirstNameIgnoreCaseContains(@Param("firstName") String firstName);
}
