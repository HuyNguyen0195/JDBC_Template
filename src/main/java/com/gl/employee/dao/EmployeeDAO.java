package com.gl.employee.dao;

import java.util.List;

import com.gl.employee.model.Employee;

public interface EmployeeDAO 
{
	public void insert(Employee employee);
	public void update(Employee employee);
	public void delete(int id);
	public List<Employee> showAll();
}