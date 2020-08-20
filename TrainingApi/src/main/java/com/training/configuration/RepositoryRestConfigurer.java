package com.training.configuration;

import com.training.inline.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;


@Configuration
public class RepositoryRestConfigurer extends RepositoryRestConfigurerAdapter {
  
    @Override
    public void configureRepositoryRestConfiguration(
      RepositoryRestConfiguration repositoryRestConfiguration) {
        repositoryRestConfiguration.getProjectionConfiguration()
          .addProjection(InlineTrainingClassGetIdOnly.class)
          .addProjection(InlineTrainingClass.class)
          .addProjection(InlineStudent.class).addProjection(InlineStudentNameOnly.class)
          .addProjection(InlineTrainingClassTest.class);
    }
}
