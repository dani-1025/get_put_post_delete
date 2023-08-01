package com.example.sb1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student_details")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    @Column(name= "name")
    private String name ;

    @Column(name= "dept")
    private String dept ;

    public Student(Long id, String name, String dept) {
        this.id = id;
        this.name = name;
        this.dept = dept;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", dept=" + dept + "]";
    }

    public Long name() {
        return null;
    }

    public String dept() {
        return null;
    }

    


}
