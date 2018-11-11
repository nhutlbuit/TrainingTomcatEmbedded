package com.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.swagger.annotations.Api;
import com.training.model.Course;

@Api(tags = "Course information")
@RepositoryRestResource(collectionResourceRel = "course", path = "course")
public interface CourseRepository extends JpaRepository<Course, Long> {

}
