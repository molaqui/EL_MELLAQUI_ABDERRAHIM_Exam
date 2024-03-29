package com.ecom.devoir_crud_jsf.controller;


import com.ecom.devoir_crud_jsf.dao.EmployeeDao;
import com.ecom.devoir_crud_jsf.dao.EmployeeDaoImpl;
import com.ecom.devoir_crud_jsf.model.entity.Employee;
import com.ecom.devoir_crud_jsf.service.EmployeeService;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.Date;
import java.util.List;
import java.util.Map;

@ManagedBean
@RequestScoped
public class EmployeeBean {

    private int selectedEmployeeId;
    private int selectedProjectId;
    private double selectedImplication;
    private List<Employee> employees;
    private EmployeeDao employeeDao=new EmployeeDaoImpl();
    private EmployeeService employeeService=new EmployeeService(employeeDao);
    private Employee newEmployee;
    private int id;
    private String name;
    private String email;

    public int getSelectedEmployeeId() {
        return selectedEmployeeId;
    }

    public void setSelectedEmployeeId(int selectedEmployeeId) {
        this.selectedEmployeeId = selectedEmployeeId;
    }

    public int getSelectedProjectId() {
        return selectedProjectId;
    }

    public void setSelectedProjectId(int selectedProjectId) {
        this.selectedProjectId = selectedProjectId;
    }

    public double getSelectedImplication() {
        return selectedImplication;
    }

    public void setSelectedImplication(double selectedImplication) {
        this.selectedImplication = selectedImplication;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee getNewEmployee() {
        return newEmployee;
    }

    public void setNewEmployee(Employee newEmployee) {
        this.newEmployee = newEmployee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    private List<String> skills;

    public EmployeeBean(List<Employee> employees, EmployeeDao employeeDao, EmployeeService employeeService, Employee newEmployee, int id, String name, String email, List<String> skills) {
        this.employees = employees;
        this.employeeDao = employeeDao;
        this.employeeService = employeeService;
        this.newEmployee = newEmployee;
        this.id = id;
        this.name = name;
        this.email = email;
        this.skills = skills;
    }

    public EmployeeBean() {
        newEmployee = new Employee();
    }

    public List<Employee> GetEmployees() {
        EmployeeDao employeeDao=new EmployeeDaoImpl();
        EmployeeService employeeService = new EmployeeService(employeeDao);
        employees =employeeService.getAllEmployees() ;
        return employees;
    }

    public String assignProjectToEmployee() {
        try {
            employeeService.assignProjectToEmployee(selectedEmployeeId, selectedProjectId, selectedImplication);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Project assigned successfully"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to assign project"));
        }
        return "employeeList?faces-redirect=true";
    }

}
