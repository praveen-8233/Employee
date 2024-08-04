package com.employee.repository;

import com.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "Select * from emp_tbl", nativeQuery = true)
    public List<Employee> getEmps();

//    @Query(value = "Update emp_tbl Set empName Where empName = John ",nativeQuery = true)
//    public Employee updateEmp();

    @Modifying
    @Transactional
    @Query(value = "UPDATE emp_tbl SET emp_name = :newName WHERE emp_name = :oldName ", nativeQuery = true)
    int updateEmp(String newName, String oldName);

    @Modifying
    @Transactional
    @Query(value = " DELETE FROM emp_tbl WHERE emp_id = :empId", nativeQuery = true)
    int deleteRecord(Integer empId);

//    @Modifying
//    @Query("insert into Employee (empId,empName,dept,empSalary,designation) select :id,:name,:depart,:empSalary,:designation from Dual")
//    public int modifyingQueryInsertEmployee(@Param("id") Integer id,
//                                          @Param("name") String name,
//                                          @Param("depart") String depart,
//                                          @Param("empSalary") Double empSalary,
//                                          @Param("designation")String designation);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO emp_tbl (emp_id, emp_name, dept, emp_salary, designation) VALUES (:id, :name, :depart, :empSalary, :designation)", nativeQuery = true)
    int modifyingQueryInsertEmployee(@Param("id") Integer id,
                                     @Param("name") String name,
                                     @Param("depart") String depart,
                                     @Param("empSalary") Double empSalary,
                                     @Param("designation") String designation);


}
