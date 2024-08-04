package com.employee.repository;

import com.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Query(value = "Select * from emp_tbl",nativeQuery = true)
    public List<Employee> getEmps();

//    @Query(value = "Update emp_tbl Set empName Where empName = John ",nativeQuery = true)
//    public Employee updateEmp();

    @Modifying
    @Transactional
    @Query(value = "UPDATE emp_tbl SET emp_name = :newName WHERE emp_name = :oldName ",nativeQuery = true)
    int updateEmp(String newName,String oldName);

    @Modifying
    @Transactional
    @Query ( value = "Delete from emp_tbl Where emp_id = :empId",nativeQuery = true)
    int deleteRecord(Integer empId);


}
