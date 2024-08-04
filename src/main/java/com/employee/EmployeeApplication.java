package com.employee;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class EmployeeApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(EmployeeApplication.class, args);
		EmployeeRepository repo = context.getBean(EmployeeRepository.class);
/*
		Employee e1 = new Employee(1,"John","Admin",1500.00,"Manager");
		Employee e2 = new Employee(2,"Robert","IT",2500.00,"Asst Manager");
		Employee e3 = new Employee(3,"Smith","Quality",3500.00,"Senior Manager");
		Employee e4 = new Employee(4,"Raayan","Security",4500.00,"Manager");
		Employee e5 = new Employee(5,"Mike","Management",5500.00,"Team Lead");
		Employee e6 = new Employee(6,"Rehana","Admin 1",6500.00,"Manager");
		Employee e7 = new Employee(7,"Rayn","Admin",1500.00,"Vice President");

		List<Employee> s = repo.saveAll(Arrays.asList(e1, e2, e3, e4, e5, e6, e7));
		s.forEach(System.out::println);
		*/

		Sort empName = Sort.by("empName").ascending();
		List<Employee> list = repo.findAll(empName);
		list.forEach(System.out::println);
	}

}
