package com.fr.task.taskforfr.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class RequestSaveResult {
    String question;
    TypeQuestion type;
    List<String> answer;
}
