package com.fr.task.taskforfr.models;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class ResponseCRUDOperation {
    String answer;
}
