package com.presentation.andy.model;

import com.presentation.andy.projects.Projects;

import javax.persistence.*;


@Entity
@Table(name = "worker")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer salary;
    private String name;
    private String cdTasks;
    private String outstandingTasks;
    @Enumerated(EnumType.STRING)
    private Projects workProjects;
    private Boolean online;

    public Worker(Integer salary, String name, String cdTasks, String outstandingTasks, Projects workProjects, Boolean online) {
        this.salary = salary;
        this.name = name;
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

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCdTasks() {
        return cdTasks;
    }

    public void setCdTasks(String completedTasks) {
        this.cdTasks = completedTasks;
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



