package com.training.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.service.TrainingClassService;
import com.training.util.DateUtils;

@RestController
@RequestMapping("api")

public class TrainingClassController {

	private final Logger logger = LoggerFactory.getLogger(TrainingClassController.class);
	
	@Autowired
	TrainingClassService trainingClassService;

	@GetMapping(value = "/classAttendee/export")
	public void exportIrt(HttpServletResponse response) {
		String fileName = "classAttendee" + "_" + DateUtils.getCurrentDateAM_PM() +".xlsx";
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
		Workbook workbook;
		workbook = trainingClassService.sPP1Course();
		
		try {
			workbook.write(response.getOutputStream());
			workbook.close();
		} catch (IOException e) {
			logger.error("Failed to export");
		}
	}

	

}
