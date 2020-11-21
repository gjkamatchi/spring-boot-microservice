package com.ps.verizon.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ps.verizon.model.Employee;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long>{

	List<Employee> findAllByPlace(final String place);
	
	List<Employee> findAllByPlace(final String place,Pageable pagable);
	
	List<Employee> findAllByCompetencies(final String competencies);
	
	@Query(value = " SELECT count(1) as empCount, salary , CASE " 
			+ " WHEN salary BETWEEN 0 and 5000 THEN '0-5000'"
			+ " WHEN salary BETWEEN 5001 and 10000 THEN '0-5000'" 
			+ " WHEN salary BETWEEN 10001 and 20000 THEN '10001-2000'"
			+ " WHEN salary BETWEEN 20001 and 30000 THEN '20001-3000'"
			+ " WHEN salary BETWEEN 30001 and 40000 THEN '30001-4000'"
			+ " WHEN salary BETWEEN 40001 and 50000 THEN '40001-5000'"
			+ " WHEN salary BETWEEN 50001 and 60000 THEN '50001-6000'"
			+ " WHEN salary BETWEEN 60001 and 70000 THEN '60001-7000'"
			+ " WHEN salary BETWEEN 70001 and 80000 THEN '70001-80000'"
			+ " WHEN salary BETWEEN 80001 and 90000 THEN '80001-90000'"
			+ " WHEN salary BETWEEN 90001 and 100000 THEN '90001-100000'" 
			+ " WHEN salary  > 100000  THEN '>100000'"
			+ " END as range  FROM EMPLOYEE "
			+ " WHERE COMPETENCIES IN (?1) GROUP BY range,salary ",nativeQuery = true)
	List<Object> findSalaryRangeByCompetency(final String competency);
	
}
