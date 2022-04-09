package com.fr.task.taskforfr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "answer_to_question", schema = "public")
public class AnswerToQuestionEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue
    Integer id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_survey")
    @JsonIgnore
    private SurveyEntity idSurvey;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_question")
    @JsonIgnore
    private QuestionEntity idQuestion;

    @Column(name="identifier_user")
    private String identifierUser;

    @Column(name="answer")
    private String answer;

}
