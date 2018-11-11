package com.training.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import com.training.inline.InlineTrainingClass;
import com.training.inline.InlineTrainingClassGetIdOnly;


@Configuration
public class RepositoryRestConfigurer extends RepositoryRestConfigurerAdapter {
  
    @Override
    public void configureRepositoryRestConfiguration(
      RepositoryRestConfiguration repositoryRestConfiguration) {
        repositoryRestConfiguration.getProjectionConfiguration()
          .addProjection(InlineTrainingClassGetIdOnly.class)
          .addProjection(InlineTrainingClass.class);
    }
}
