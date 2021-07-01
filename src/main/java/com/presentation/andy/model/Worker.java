package com.presentation.andy.model;

import com.presentation.andy.projects.Projects;

import javax.persistence.*;


@Entity
@Table(name = "worker")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer salary ;
    private String name;
    private String completedTasks;
    private String outstandingTasks;
   @Enumerated( EnumType.STRING )
    private Projects workProjects;
    private Boolean online;

    public Worker() {
    }

    public Worker( int salary, String name, String completedTasks, String outstandingTasks, Projects workProjects, Boolean online) {
        this.id = id;
        this.salary = salary;
        this.name = name;
        this.completedTasks = completedTasks;
        this.outstandingTasks = outstandingTasks;
        this.workProjects = workProjects;
        this.online = online;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int performance) {
        this.salary = performance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompletedTasks() {
        return completedTasks;
    }

    public void setCompletedTasks(String completedTasks) {
        this.completedTasks = completedTasks;
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

