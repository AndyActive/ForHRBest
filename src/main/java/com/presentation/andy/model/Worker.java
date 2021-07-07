package com.presentation.andy.model;

import com.presentation.andy.projects.Projects;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "worker")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private Integer salary;
    private String firstName;
    private String lastName;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Enumerated(value = EnumType.STRING)
    private Status status;
    private String cdTasks;
    private String outstandingTasks;
    @Enumerated(EnumType.STRING)
    private Projects workProjects;
    private Boolean online;

    public Worker(String email, String password, Integer salary, String firstName, String lastName, Role role, Status status, String cdTasks, String outstandingTasks, Projects workProjects, Boolean online) {
        this.email = email;
        this.password = password;
        this.salary = salary;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.status = status;
        this.cdTasks = cdTasks;
        this.outstandingTasks = outstandingTasks;
        this.workProjects = workProjects;
        this.online = online;
    }

    public Worker() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCdTasks() {
        return cdTasks;
    }

    public void setCdTasks(String cdTasks) {
        this.cdTasks = cdTasks;
    }

    public String getOutstandingTasks() {
        return outstandingTasks;
    }

    public void setOutstandingTasks(String outstandingTasks) {
        this.outstandingTasks = outstandingTasks;
    }

    public Projects getWorkProjects() {
        return workProjects;
    }

    public void setWorkProjects(Projects workProjects) {
        this.workProjects = workProjects;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }
}


