package com.sunil.server.testnewserver.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunil.server.testnewserver.model.Employee;

@RestController
@Controller
public class EmployeeController {

		@RequestMapping(value = "/user/getEmployeesList", produces = "application/json")
		@ResponseBody
	    public List<Employee> getEmployeesList() {
			
			System.out.println("In EmployeeController Class from Server");
			
	        List<Employee> employees = new ArrayList<>();
	        Employee emp = new Employee();
	        emp.setEmpId("100");
	        emp.setEmpName("Sunil");
	        employees.add(emp);
	        
	        Employee emp1 = new Employee();
	        emp1.setEmpId("101");
	        emp1.setEmpName("Reena");
	        employees.add(emp1);
	        
	        Employee emp2 = new Employee();
	        emp2.setEmpId("104");
	        emp2.setEmpName("Nidhi");
	        employees.add(emp2);
	        
	        Employee emp3 = new Employee();
	        emp3.setEmpId("106");
	        emp3.setEmpName("Pradeep");
	        employees.add(emp3);
	        
	        System.out.println("List of Employees: "+employees);
	        
	        return employees;

	    }
}