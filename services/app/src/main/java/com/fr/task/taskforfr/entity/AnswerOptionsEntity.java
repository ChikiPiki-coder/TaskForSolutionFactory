package com.fr.task.taskforfr.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "answer_options", schema = "public")
public class AnswerOptionsEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue
    Integer id;

    @Column(name="answer_options")
    private String answerOptions;

    @Column(name="number_answer")
    private int numberAnswer;

    @JoinColumn(name = "id_question")
    @ManyToOne
    private QuestionEntity idQuestion;
}
