package com.ps.verizon.service;

import java.util.List;

import com.ps.verizon.response.EmployeeDetails;
import com.ps.verizon.response.SalaryRange;

public interface EmployeeService {

	List<EmployeeDetails> udpateEmployeeDetails(final String place,final Double percentage);
	
	List<EmployeeDetails> getEmployeeList(final String place,final int page,final int size);
	
	List<SalaryRange> getSalaryRange(final String competency);
}
