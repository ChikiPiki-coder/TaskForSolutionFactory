package com.fr.task.taskforfr.entity;

import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name = "question_table", schema = "public")
public class QuestionEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue
    Integer id;

    @Column(name="question")
    private String question;

    @Column(name="type_question")
    private String typeQuestion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_survey")
    private SurveyEntity idSurvey;

    @OneToMany(mappedBy = "idQuestion",
            cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<AnswerOptionsEntity> answerOptionsEntityList;

    @OneToMany(mappedBy = "idQuestion",
            cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<AnswerToQuestionEntity> answerToQuestionEntities;

}
