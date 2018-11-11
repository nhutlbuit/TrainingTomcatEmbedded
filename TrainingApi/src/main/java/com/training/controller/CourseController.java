package com.training.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.service.CourceService;


@RestController
@RequestMapping("/custom/course")
public class CourseController {
	
	 @Autowired
	 CourceService courceService;

	 private static final Logger logger = LoggerFactory.getLogger("CourseController");

	@PostMapping(value = "/insert", produces = {"application/json"})
	public ResponseEntity<?> insert(@RequestBody String rqBody, HttpServletRequest rq, HttpServletResponse respons) {
		final long startTime = System.nanoTime();
		
		try {
			courceService.save(rqBody);
			
			long endTime = System.nanoTime();
			long elapsedTime = endTime - startTime;
			double seconds = (double) elapsedTime / 1000000000.0;
			logger.debug("TaskResponse_Time is {0}", String.valueOf(seconds));
		} catch (Exception e) {
			logger.debug("Error on Calculate time running !!");
		}
		return ResponseEntity.ok(Status.OK);
	}
	
	@PostMapping(value = "/update", produces = {"application/json"})
	public ResponseEntity<?> update(@RequestBody String rqBody) {
		final long startTime = System.nanoTime();
		boolean status = false;
		try {
			status = courceService.update(rqBody);
			
			long endTime = System.nanoTime();
			long elapsedTime = endTime - startTime;
			double seconds = (double) elapsedTime / 1000000000.0;
			logger.debug("TaskResponse_Time is {0}", String.valueOf(seconds));
		} catch (Exception e) {
			logger.debug("Error on Calculate time running !!");
		}
		return new ResponseEntity<String>(String.valueOf(status), HttpStatus.OK);
	}

}
