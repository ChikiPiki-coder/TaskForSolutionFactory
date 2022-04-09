package com.fr.task.taskforfr.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class RequestCreateSurvey {
    String name;
    LocalDate start;
    LocalDate finish;
    String description;

}
