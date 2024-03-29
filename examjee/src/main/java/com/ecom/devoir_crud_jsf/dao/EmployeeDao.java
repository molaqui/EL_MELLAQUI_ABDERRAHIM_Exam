package com.ecom.devoir_crud_jsf.dao;

import com.ecom.devoir_crud_jsf.model.entity.Employee;

import java.util.List;

public interface EmployeeDao{
    List<Employee> getAllEmployees();
    void assignProjectToEmployee(int employeeId, int projectId, double implication);

    Employee getEmployeeById(int employeeId);

}
