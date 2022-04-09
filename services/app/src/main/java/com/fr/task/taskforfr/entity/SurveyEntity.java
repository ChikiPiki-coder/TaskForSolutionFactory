package com.fr.task.taskforfr.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "survey", schema = "public")
public class SurveyEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue
    Integer id;

    @Column(name="name")
    private String name;

    @Column(name="start")
    private LocalDate start;

    @Column(name="finish")
    private LocalDate finish;

    @Column(name="description")
    private String description;

    @OneToMany(mappedBy = "idSurvey", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private List<QuestionEntity> questionEntities;

    @OneToMany(mappedBy = "idSurvey", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private List<AnswerToQuestionEntity> answerToQuestionEntities;


}
