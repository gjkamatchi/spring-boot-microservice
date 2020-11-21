package com.ps.verizon.response;

public class SalaryRange {

	private String range;
	
	private Long salary;
	
	private Long empCount;
	
	public SalaryRange() {
		
	}

	public SalaryRange(String range, Long salary, Long empCount) {
		super();
		this.range = range;
		this.salary = salary;
		this.empCount = empCount;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public Long getEmpCount() {
		return empCount;
	}

	public void setEmpCount(Long empCount) {
		this.empCount = empCount;
	}

	@Override
	public String toString() {
		return "SalaryRange [range=" + range + ", salary=" + salary + ", empCount=" + empCount + "]";
	}
	
}
