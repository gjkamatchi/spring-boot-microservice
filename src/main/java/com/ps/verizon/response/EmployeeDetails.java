package com.ps.verizon.response;

public class EmployeeDetails {

	private String employeeName;

	private String title;

	private String businessUnit;
	
	private String place;
	
	private String supervisorId;
	
	private String competencies;
	
	private Long salary;

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(String supervisorId) {
		this.supervisorId = supervisorId;
	}

	public String getCompetencies() {
		return competencies;
	}

	public void setCompetencies(String competencies) {
		this.competencies = competencies;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [employeeName=" + employeeName + ", title=" + title + ", businessUnit=" + businessUnit
				+ ", place=" + place + ", supervisorId=" + supervisorId + ", competencies=" + competencies + ", salary="
				+ salary + "]";
	}
	
}
