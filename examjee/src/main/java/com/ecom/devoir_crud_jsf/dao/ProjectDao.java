package com.ecom.devoir_crud_jsf.dao;


import com.ecom.devoir_crud_jsf.model.entity.Project;
import java.util.List;

public interface ProjectDao {
    List<Project> getAllProjects();
    Project findProjectById(int id);
    void createProject(Project project);
    void updateProject(Project project);
    void deleteProject(int id);
}
