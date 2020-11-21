package com.ps.verizon.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.ps.verizon.exception.PercentageException;
import com.ps.verizon.exception.RecordNotfoundException;
import com.ps.verizon.model.Employee;
import com.ps.verizon.repository.EmployeeRepository;
import com.ps.verizon.response.EmployeeDetails;
import com.ps.verizon.response.SalaryRange;
import com.ps.verizon.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeRepository employeeRepository;
	

	@Override
	public List<EmployeeDetails> udpateEmployeeDetails(final String place, final Double percentage) {
		List<Employee> employees = new ArrayList<>();
		final List<Employee> employeeList = employeeRepository.findAllByPlace(place);
		if(CollectionUtils.isEmpty(employeeList))
			throw new RecordNotfoundException("Record Not Found!");
		employeeList.forEach(emp -> {
			if (percentage > 55) {
				throw new PercentageException(percentage+" : Percentage Not allowed!");
			}
			final Long salary = (long) (emp.getSalary() * percentage / 100);
			final Long finalSalary  = emp.getSalary()+salary;
			LOGGER.info("Salary => {}", finalSalary);
			emp.setSalary(finalSalary);
			employees.add(emp);
		});
		final List<Employee> finalEmpList = (List<Employee>) employeeRepository.saveAll(employees);
		return getEmployeeDetails(finalEmpList);
	}

	@Override
	public List<EmployeeDetails> getEmployeeList(final String place,final int page,final int size) {
		Pageable paging = PageRequest.of(page, size);
		final List<Employee> employeeList = employeeRepository.findAllByPlace(place,paging);
		if(CollectionUtils.isEmpty(employeeList))
			throw new RecordNotfoundException("Record Not Found!");
		return getEmployeeDetails(employeeList);
	}
	
	private List<EmployeeDetails> getEmployeeDetails(final List<Employee> employeeList){
		List<EmployeeDetails> empList = new ArrayList<>();
		employeeList.forEach(emp->{
			EmployeeDetails employeeDetails= new EmployeeDetails();
			employeeDetails.setSalary(emp.getSalary());
			employeeDetails.setPlace(emp.getPlace());
			employeeDetails.setEmployeeName(emp.getEmployeeName());
			employeeDetails.setTitle(emp.getTitle());
			empList.add(employeeDetails);
		});
		return empList;
	}

	@Override
	public List<SalaryRange> getSalaryRange(final String competency) {
		List<SalaryRange> rangeList = new ArrayList<>();
		final List<Object> empList = employeeRepository.findSalaryRangeByCompetency(competency);
		if(CollectionUtils.isEmpty(empList))
			throw new RecordNotfoundException("Record Not Found!");
		Iterator<Object> crunchifyIterator = empList.iterator();
        while (crunchifyIterator.hasNext()) {
            final Object[] obj = (Object[]) crunchifyIterator.next();
            SalaryRange range = new SalaryRange();
            range.setEmpCount(Long.valueOf(obj[0].toString()));
            range.setSalary(Long.valueOf(obj[1].toString()));
            range.setRange(obj[2].toString());
            rangeList.add(range);
        }
		return rangeList;
	}

}
