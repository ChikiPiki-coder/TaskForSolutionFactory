package com.fr.task.taskforfr.entity;


import lombok.Data;

import javax.persistence.*;
import javax.persistence.GeneratedValue;

@Data
@Entity
@Table(name = "admin", schema = "public")
public class AdminEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue
    Integer id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private char[] password;

    @Column(name="name")
    private String name;

    @Column(name="last_name")
    private String lastName;


}
