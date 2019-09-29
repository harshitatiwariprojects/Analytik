package org.analytik.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Defines Controller for Reporting functionality.
 * @author Harshita Tiwari
 * Copyright 2019 by Harshita Tiwari. All rights reserved.
 *
 */
@Controller
public class ReportController {

	@GetMapping(value = "/home.htm")
	public String getDashboard(HttpServletRequest request, HttpServletResponse response,Model model) {
			
		return "home";
	}   
    
     @GetMapping(value = "/chart.htm")
     public String getChart(HttpServletRequest request, HttpServletResponse response) {

           return "chart";
     }
    
}
