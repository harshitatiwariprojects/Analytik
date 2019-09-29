package org.analytik.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Defines Data Export Controller.
 * @author Harshita Tiwari
 * Copyright 2019 by Harshita Tiwari. All rights reserved.
 *
 */
@Controller
public class ExportController {

	@GetMapping(value = "/export.htm")
	public String getExportData(HttpServletRequest request, HttpServletResponse response,Model model) {
				
		return "home";
	}
	
   
}
