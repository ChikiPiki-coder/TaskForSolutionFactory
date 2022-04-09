package com.fr.task.taskforfr.models;

import lombok.Data;

import java.util.List;

@Data
public class Question {
    String question;
    TypeQuestion typeQuestion;
    List<String> answerOptionsList;

}
