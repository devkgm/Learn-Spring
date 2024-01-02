package com.devkgm.app.departments;

public class DepartmentDTO {
	private int department_id;
	private String department_name;
	private int manager_id;
	private int lacation_id;
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	public int getLacation_id() {
		return lacation_id;
	}
	public void setLacation_id(int lacation_id) {
		this.lacation_id = lacation_id;
	}
	
	
}
