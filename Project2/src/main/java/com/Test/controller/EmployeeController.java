package com.Test.controller;

import com.Test.entity.Employee;
//import com.Test.error.EmployeeNotFoundException;
import com.Test.error.EmployeeNotFoundException;
import com.Test.service.EmpServiceImpl;
//import jakarta.validation.Valid;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {


    @Autowired
    private EmpServiceImpl empService;

    private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);




    @GetMapping("/alldept/{name}")
    public ResponseEntity<List<Employee>> getDepartmentByName(@PathVariable String name){

        List<Employee> employee = empService.fetchDepartmentByName(name);
//        logger.info("Chekcing");
        return  ResponseEntity.status(HttpStatus.OK).body(employee);

    }



    @PostMapping("/save")
    public ResponseEntity<Employee> saveEmployee( @Valid @RequestBody Employee employee){
        Employee employee1 = empService.saveEmp(employee);
        logger.info("Data Saving ");
        return  ResponseEntity.status(HttpStatus.OK).body(employee1);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) throws EmployeeNotFoundException {
        Employee employeeById = empService.getEmployeeById(id);
        logger.info("Getting The Data");
        return  ResponseEntity.status(HttpStatus.OK).body(employeeById);
    }

    @GetMapping("/all")
    public  ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> allEmployee = empService.getAllEmployee();
        logger.info("fetched All Data ");
        return  ResponseEntity.status(HttpStatus.OK).body(allEmployee);
    }



    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) throws EmployeeNotFoundException {
        empService.deleteEmployeeById(id);
        logger.info("{} Employee Deleted Succesfully ");
        return "Employee deleted Succesfully!!";
    }


    @PutMapping("/{id}")
    public  ResponseEntity<Employee> updateEmployee(@PathVariable Long id , @Valid @RequestBody Employee employee) throws EmployeeNotFoundException {

        Employee employee1 = empService.updateEmployee2(id, employee);

        return  ResponseEntity.status(HttpStatus.OK).body(employee1);
//        return  new ResponseEntity<>(emp,HttpStatus.OK);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<Employee> updateEmployeePartiallyUisngId(@PathVariable Long id, @RequestBody  Map<String,Object> fields) throws EmployeeNotFoundException {
        Employee employee = empService.updatePartially(id, fields);
        return  new ResponseEntity<>(employee,HttpStatus.OK);

    }





}
