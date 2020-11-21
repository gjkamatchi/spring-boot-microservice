package com.ps.verizon.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.ps.verizon.exception.PercentageException;
import com.ps.verizon.exception.RecordNotfoundException;
import com.ps.verizon.model.Employee;
import com.ps.verizon.repository.EmployeeRepository;


@RunWith(SpringRunner.class)
public class EmployeeServiceTests {
	
	@InjectMocks
	private EmployeeServiceImpl employeeService;

	@Mock
	private EmployeeRepository employeeRepository;
	
	@Test
	public void testUdpateEmployeeDetails() {
		final List<Employee> employeeList = new ArrayList<>();
		Employee employee = new Employee();
		employee.setTitle("Manager");
		employee.setEmployeeName("Kamatchi");
		employee.setPlace("Chennai");
		employee.setSalary(10000L);
		employee.setCompetencies("CORE");
		employeeList.add(employee);
		Mockito.when(employeeRepository.findAllByPlace(Mockito.anyString())).thenReturn(employeeList);
		Mockito.when(employeeRepository.saveAll(employeeList)).thenReturn(employeeList);
		Assert.assertNotNull(employeeService.udpateEmployeeDetails("Chennai", 15.0));
	}
	
	@Test(expected = PercentageException.class)
	public void testUdpateEmployeeDetailsWithException() {
		final List<Employee> employeeList = new ArrayList<>();
		Employee employee = new Employee();
		employee.setTitle("Manager");
		employee.setEmployeeName("Kamatchi");
		employee.setPlace("Chennai");
		employee.setSalary(10000L);
		employee.setCompetencies("CORE");
		employeeList.add(employee);
		Mockito.when(employeeRepository.findAllByPlace(Mockito.anyString())).thenReturn(employeeList);
		Mockito.when(employeeRepository.saveAll(employeeList)).thenReturn(employeeList);
		Assert.assertNotNull(employeeService.udpateEmployeeDetails("Chennai", 56.0));
	}
	
	@Test(expected = RecordNotfoundException.class)
	public void testUdpateEmployeeDetailsWithRecordNotfoundException() {
		final List<Employee> employeeList = new ArrayList<>();
		Employee employee = new Employee();
		employee.setTitle("Manager");
		employee.setEmployeeName("Kamatchi");
		employee.setPlace("Chennai");
		employee.setSalary(10000L);
		employee.setCompetencies("CORE");
		employeeList.add(employee);
		Mockito.when(employeeRepository.findAllByPlace(Mockito.anyString())).thenReturn(null);
		Mockito.when(employeeRepository.saveAll(employeeList)).thenReturn(employeeList);
		Assert.assertNotNull(employeeService.udpateEmployeeDetails("Chennai", 56.0));
	}
	
	@Test
	public void testGetEmployeeList() {
		final List<Employee> employeeList = new ArrayList<>();
		Employee employee = new Employee();
		employee.setTitle("Manager");
		employee.setEmployeeName("Kamatchi");
		employee.setPlace("Chennai");
		employee.setSalary(10000L);
		employee.setCompetencies("CORE");
		employeeList.add(employee);
		Mockito.when(employeeRepository.findAllByPlace(Mockito.anyString(),Mockito.any())).thenReturn(employeeList);
		Assert.assertNotNull(employeeService.getEmployeeList("Chennai", 0,5));
	}
	
	@Test(expected = RecordNotfoundException.class)
	public void testGetEmployeeListWithRecordNotfoundException() {
		Mockito.when(employeeRepository.findAllByPlace(Mockito.anyString(),Mockito.any())).thenReturn(null);
		Assert.assertNotNull(employeeService.getEmployeeList("Chennai", 0,5));
	}
	
	
	@Test
	public void testSalaryRangeByCompetency() {
		final List<Object> rangeList = new ArrayList<>();
		Object[] object = new Object[3];
		object[0] = "1";
		object[2] = "0-5000";
		object[1] = "10000";
		rangeList.add(object);
		Mockito.when(employeeRepository.findSalaryRangeByCompetency(Mockito.anyString())).thenReturn(rangeList);
		Assert.assertNotNull(employeeService.getSalaryRange("CORE"));
	}
	
	@Test(expected = RecordNotfoundException.class)
	public void testSalaryRangeByCompetencyWithRecordNotfoundException() {
		Mockito.when(employeeRepository.findSalaryRangeByCompetency(Mockito.anyString())).thenReturn(null);
		Assert.assertNotNull(employeeService.getSalaryRange("CORE"));
	}
	
}
