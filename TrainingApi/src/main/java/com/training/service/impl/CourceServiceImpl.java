package com.training.service.impl;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.training.repository.CourseRepository;
import com.training.service.CourceService;

import com.training.model.Course;

@Service
public class CourceServiceImpl implements CourceService {
	
//	 @Autowired
//	 CourseRepository courseRepository;
	 
	 Logger logger = Logger.getLogger(CourceServiceImpl.class);

	@Override
	public void save(String rqBody) {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node;
		try {
			node = mapper.readTree(rqBody);
			Course course = new Course();
			course.setCourseCode(node.findPath("courseCode").textValue());
			course.setCourseName(node.findPath("courseName").textValue());
			course.setQualifiedScore(node.findPath("qualifiedScore").doubleValue());
//			courseRepository.saveAndFlush(course);
		} catch (Exception e) {
			if (e instanceof JsonProcessingException) {
				logger.error("JsonProcessingException {0}", e);
			} else if (e instanceof IOException) {
				logger.error("IOException {0}", e);
			} else {
				logger.error("error" + e);
			}
		}
	}

	@Override
	public boolean update(String rqBody) {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node;
		boolean status = false;
		try {
			node = mapper.readTree(rqBody);
			JsonNode id = node.findPath("id");
			if(!id.isMissingNode()) {
//				Course course = courseRepository.getOne(id.longValue());
//
//				JsonNode courseCode = node.findPath("courseCode");
//				if(!courseCode.isMissingNode())
//					course.setCourseCode(courseCode.textValue());
//
//				JsonNode courseName = node.findPath("courseName");
//				if(!courseName.isMissingNode())
//					course.setCourseName(courseName.textValue());
//
//				JsonNode qualifiedScore = node.findPath("qualifiedScore");
//				if(!qualifiedScore.isMissingNode())
//					course.setQualifiedScore(qualifiedScore.doubleValue());
//
//				courseRepository.saveAndFlush(course);
				status = true;
			} else {
				logger.error("Id is not existed ");
			}
			
		} catch (Exception e) {
			if (e instanceof JsonProcessingException) {
				logger.error("JsonProcessingException {0}", e);
			} else if (e instanceof IOException) {
				logger.error("IOException {0}", e);
			} else {
				logger.error("error" + e);
			}
		}
		return status;
	}

	
}
