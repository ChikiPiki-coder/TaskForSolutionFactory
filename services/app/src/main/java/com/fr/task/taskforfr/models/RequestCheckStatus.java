package com.fr.task.taskforfr.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class RequestCheckStatus {
    String status;
    String login;
    char[] password;
}
