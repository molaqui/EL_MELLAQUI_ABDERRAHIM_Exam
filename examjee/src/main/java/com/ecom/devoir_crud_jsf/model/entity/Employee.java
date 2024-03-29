package com.ecom.devoir_crud_jsf.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
    public Employee() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    @ElementCollection
    private List<String> skills;
    @Enumerated(EnumType.STRING)
    private Post post;

    private double implication;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public Employee(int id, String name, String email, List<String> skills) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.skills = skills;
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public void setImplication(double implication) {

    }

    public double getImplication() {
        return implication;
    }
}
