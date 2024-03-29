package com.ecom.devoir_crud_jsf.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double budget;
    private int implication;



    @OneToMany(mappedBy = "project")
    private List<Employee> employees;

    protected Project() {
    }

    public Project(String name, double budget) {
        this.name = name;
        this.budget = budget;
    }

    public int getId() {
        return id;
    }

    public Project(int id, String name, double budget, int implication) {
        this.id = id;
        this.name = name;
        this.budget = budget;
        this.implication = implication;
    }

    public int getImplication() {
        return implication;
    }

    public void setImplication(int implication) {
        this.implication = implication;
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

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

}
