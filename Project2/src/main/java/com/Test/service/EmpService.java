package com.Test.service;

import com.Test.entity.Employee;
//import com.Test.error.EmployeeNotFoundException;
import com.Test.error.EmployeeNotFoundException;

import java.util.List;
import java.util.Map;

public interface EmpService {

    public Employee saveEmp(Employee employee);

    public  Employee getEmployeeById(Long id) throws EmployeeNotFoundException;

    public List<Employee> getAllEmployee();

    public  void deleteEmployeeById(Long id) throws EmployeeNotFoundException;

    public  Employee updateEmployee2(Long id , Employee employee ) throws EmployeeNotFoundException;

    Employee updatePartially(Long id, Map<String, Object> fields) throws EmployeeNotFoundException;


    //get All employees belongs to entered department name
    public List<Employee> fetchDepartmentByName(String name);


}
