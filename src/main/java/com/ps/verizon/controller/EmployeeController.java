package com.ps.verizon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ps.verizon.service.impl.EmployeeServiceImpl;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;

	@PutMapping(path = "/employee/place/{place}/salary/{percentage}")
	public ResponseEntity<?> updateEmployee(@PathVariable(value = "place") final String place,
			@PathVariable(value = "percentage") final Double percentage) {
		return new ResponseEntity<>(employeeService.udpateEmployeeDetails(place, percentage), HttpStatus.OK);
	}

	@GetMapping(path = "/employee/place/{place}/{pageSize}")
	public ResponseEntity<?> getEmployeeList(@PathVariable(value = "place") final String place,
			@PathVariable(value = "pageSize") final int pageSize) {
		return new ResponseEntity<>(employeeService.getEmployeeList(place, 0, pageSize), HttpStatus.OK);
	}
	
	@GetMapping(path = "/employee/{competency}")
	public ResponseEntity<?> getSalaryRange(@PathVariable(value = "competency") final String competency) {
		return new ResponseEntity<>(employeeService.getSalaryRange(competency), HttpStatus.OK);
	}
	
}
