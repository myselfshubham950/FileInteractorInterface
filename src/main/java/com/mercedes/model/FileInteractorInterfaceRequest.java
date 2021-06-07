package com.mercedes.model;

import javax.validation.constraints.NotNull;

public class FileInteractorInterfaceRequest {
	
	@NotNull
	private FileInteractorInterfaceHeader header;
	@NotNull
	private String name;
	@NotNull
	private String dob;
	@NotNull
	private String salary;
	@NotNull
	private Integer age;
	private String updatedName;
	private String updatedDob;
	private String updatedSalary;
	private Integer updatedAge;
	
	public FileInteractorInterfaceHeader getHeader() {
		return header;
	}
	public void setHeader(FileInteractorInterfaceHeader header) {
		this.header = header;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getUpdatedName() {
		return updatedName;
	}
	public void setUpdatedName(String updatedName) {
		this.updatedName = updatedName;
	}
	public String getUpdatedDob() {
		return updatedDob;
	}
	public void setUpdatedDob(String updatedDob) {
		this.updatedDob = updatedDob;
	}
	public String getUpdatedSalary() {
		return updatedSalary;
	}
	public void setUpdatedSalary(String updatedSalary) {
		this.updatedSalary = updatedSalary;
	}
	public Integer getUpdatedAge() {
		return updatedAge;
	}
	public void setUpdatedAge(Integer updatedAge) {
		this.updatedAge = updatedAge;
	}
	
}
