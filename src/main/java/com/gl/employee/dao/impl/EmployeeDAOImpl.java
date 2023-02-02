package com.gl.employee.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.gl.employee.dao.EmployeeDAO;
import com.gl.employee.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO
{

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void insert(Employee employee)
	{

		String sql = "INSERT INTO EMPLOYEE "
				+ "(EMPLOYEE_ID, EMP_NAME, AGE,SALARY) VALUES (?, ?, ?,?)";

		int rowInserted=jdbcTemplate.update(sql,
				new Object[] { employee.getEmployeeId(),
						employee.getName(), employee.getAge(),
						employee.getSalary() });
		if(rowInserted>0) {
			System.out.println("inserted");
		}else {
			System.out.println("not insert");
		}
	}
	public void update(Employee employee)
	{

		String sql = "update EMPLOYEE "
				+ "set EMP_NAME=?, AGE=?,SALARY=? where employee_id=?";

		int rowUpdate=jdbcTemplate.update(sql,
				new Object[] { employee.getName(), employee.getAge(),
						employee.getSalary(),employee.getEmployeeId() });
		if(rowUpdate>0) {
			System.out.println("updated");
		}else {
			System.out.println("not update");
		}
	}
	public void delete(int id)
	{

		String sql = "delete from EMPLOYEE "
				+ "where employee_id=?";

		int rowDelete=jdbcTemplate.update(sql,
				new Object[] { id });
		if(rowDelete>0) {
			System.out.println("deleted");
		}else {
			System.out.println("not delete");
		}
	}
	public List<Employee> showAll() {
		// TODO Auto-generated method stub
		String sql="Select * from employee";
		List<Employee> list=  jdbcTemplate.query(sql,new RowMapper<Employee>(){  
		    public Employee mapRow(ResultSet rs, int rownumber) throws SQLException {  
		        Employee e=new Employee(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));   
		        return e;  }}  
		    );
		return list;
	}
	
}
