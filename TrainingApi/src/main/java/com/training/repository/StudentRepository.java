package com.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.training.model.Student;

@Api(tags = "Student information")
@RepositoryRestResource()
public interface StudentRepository extends JpaRepository<Student, Long> {

	@ApiOperation("Find by FirstName  ")
	@RestResource(path = "byFirstName")
	List<Student> findByFirstNameIgnoreCase(@Param("firstName") String firstName);
}
