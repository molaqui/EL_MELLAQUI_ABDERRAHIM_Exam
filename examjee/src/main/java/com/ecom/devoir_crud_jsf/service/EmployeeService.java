package com.ecom.devoir_crud_jsf.service;

import com.ecom.devoir_crud_jsf.dao.EmployeeDao;
import com.ecom.devoir_crud_jsf.dao.ProjectDao;
import com.ecom.devoir_crud_jsf.model.entity.Employee;
import com.ecom.devoir_crud_jsf.model.entity.Project;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

public class EmployeeService {
    private EmployeeDao employeeDao;
    private ProjectDao projectDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    public void assignProjectToEmployee(int employeeId, int projectId, double implication) {
        Employee employee = employeeDao.getEmployeeById(employeeId);
        Project project = projectDao.findProjectById(projectId);
        if (employee != null && project != null) {
            employee.setProject(project);
            employee.setImplication(implication);
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to assign project"));
        }
    }
}
