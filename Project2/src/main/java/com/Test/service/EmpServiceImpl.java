package com.Test.service;

import com.Test.entity.Employee;
import com.Test.error.EmployeeNotFoundException;
import com.Test.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmpServiceImpl implements  EmpService {


    @Autowired
    private EmployeeRepository employeeRepository;



    //get list of all Employees , department asociated with it || find employee by department name
    @Override
    public List<Employee> fetchDepartmentByName(String name) {
        return employeeRepository.findByDeptName(name);
    }


    @Override
    public Employee saveEmp(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) throws EmployeeNotFoundException {

        Optional<Employee> employee = employeeRepository.findById(id);
        if (!employee.isPresent()) {
            throw new EmployeeNotFoundException("Employee Not Found");
        } else {
            return employee.get();
        }
    }


    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }


    @Override
    public void deleteEmployeeById(Long id) throws EmployeeNotFoundException {

        if (id != null && employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        } else {
            throw new EmployeeNotFoundException("Employee Not Found !!!!!");
        }
    }

    @Override
    public Employee updateEmployee2(Long id, Employee employee) throws EmployeeNotFoundException {

        Employee updateEmployee = employeeRepository.findById(id).
                orElseThrow(() -> new EmployeeNotFoundException("Employee not exist with this id: " + id));

        updateEmployee.setName(employee.getName());
        updateEmployee.setAddress(employee.getAddress());
        updateEmployee.setSalary(employee.getSalary());
        updateEmployee.setEmail(employee.getEmail());
        updateEmployee.setEjoinDate(employee.getEjoinDate());

        Employee save = employeeRepository.save(updateEmployee);

        return save;

    }

    @Override
    public Employee updatePartially(Long id, Map<String, Object> fields) throws EmployeeNotFoundException {
        Optional<Employee> e = employeeRepository.findById(id);

        if (e.isPresent()) {

            fields.forEach((Key, Value) -> {
                Field field = ReflectionUtils.findField(Employee.class, Key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, e.get(), Value);
            });
            return employeeRepository.save(e.get());
        }
        return null;
    }



}
