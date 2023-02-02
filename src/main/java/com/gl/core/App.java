package com.gl.core;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gl.employee.dao.EmployeeDAO;
import com.gl.employee.model.Employee;

public class App
{
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		EmployeeDAO employeeDAO = (EmployeeDAO) context
				.getBean("employeeDAO");
		
		Scanner sc=new Scanner(System.in);
		int choice=0;
		
		while(choice!=5) {
			System.out.println("1-create");
			System.out.println("2-update");
			System.out.println("3-delete");
			System.out.println("4-show all");
			System.out.println("5-exit");
			System.out.println("enter your choice:");
			choice=sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("enter Id");
				int id=sc.nextInt();
				System.out.println("enter name");
				String name=sc.next();
				System.out.println("enter age");
				int age=sc.nextInt();
				System.out.println("enter salary");
				int salary=sc.nextInt();
				Employee employee = new Employee(id, name, age, salary);
				employeeDAO.insert(employee);
				break;
			case 2:
				System.out.println("enter Id");
				 id=sc.nextInt();
				System.out.println("enter name");
				 name=sc.next();
				System.out.println("enter age");
				 age=sc.nextInt();
				System.out.println("enter salary");
				 salary=sc.nextInt();
				 employee=new Employee(id, name, age, salary);
				employeeDAO.update(employee);
				break;
			case 3:
				System.out.println("enter id");
				id=sc.nextInt();
				employeeDAO.delete(id);
				break;
			case 4:
				
				for(Employee e:employeeDAO.showAll()) {
					System.out.println(e.toString());
				}
				break;
			case 5: System.exit(0);
			default:
				break;
			}
		}
	}
}
