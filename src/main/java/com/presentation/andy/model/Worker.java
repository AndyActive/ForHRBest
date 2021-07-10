package com.presentation.andy.model;

import com.presentation.andy.enums.Projects;
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
    private String firstname;
    private String lastname;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Enumerated(value = EnumType.STRING)
    private Status status;
    private String cdtasks;
    private String outstandingtasks;
    @Enumerated(EnumType.STRING)
    private Projects workprojects;
    private Boolean online;
    private String outtask;

    public Worker() {
    }

    public Worker(String email, String password, Integer salary, String firstname, String lastname, Role role, Status status, String cdtasks, String outstandingtasks, Projects workprojects, Boolean online, String outtask) {
        this.email = email;
        this.password = password;
        this.salary = salary;
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
        this.status = status;
        this.cdtasks = cdtasks;
        this.outstandingtasks = outstandingtasks;
        this.workprojects = workprojects;
        this.online = online;
        this.outtask = outtask;
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


    public String getPassword() {
        return password;
    }


    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public String getCdtasks() {
        return cdtasks;
    }

    public void setCdtasks(String cdtasks) {
        this.cdtasks = cdtasks;
    }

    public String getOutstandingtasks() {
        return outstandingtasks;
    }

    public void setOutstandingtasks(String outstandingtasks) {
        this.outstandingtasks = outstandingtasks;
    }

    public Projects getWorkprojects() {
        return workprojects;
    }

    public void setWorkprojects(Projects workprojects) {
        this.workprojects = workprojects;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public String getOuttask() {
        return outtask;
    }

    public void setOuttask(String outtask) {
        this.outtask = outtask;
    }
}


