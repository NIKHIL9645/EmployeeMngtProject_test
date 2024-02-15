package com.Test.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
//import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "employee")
@Builder
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Employee Name Required")
    @Column(name = "ename")
    private String name;

    @NotBlank(message = "Employee Address Required")
    @Column(name = "address")
    private String address;

    @NotNull(message = "Salary must")
    @Column(name = "salary")
    private double salary;

    @NotBlank(message = "Employee Email must ")
    @Column(name = "email")
    private  String email;

    @Column(name = "ejoinDate")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date ejoinDate;



}
