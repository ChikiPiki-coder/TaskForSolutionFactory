package com.fr.task.taskforfr.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user", schema = "public")
public class UserEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue
    Integer id;

    @Column(name="identifier")
    private String identifier;

}
