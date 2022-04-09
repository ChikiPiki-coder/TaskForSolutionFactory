package com.fr.task.taskforfr.controllers;


import com.fr.task.taskforfr.dao.*;
import com.fr.task.taskforfr.entity.SurveyEntity;
import com.fr.task.taskforfr.entity.UserEntity;
import com.fr.task.taskforfr.models.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/surveys")
public class SurveyController {

    private final ResponseCRUDOperation responseCRUDOperation;

    private final AdminDao adminDao;
    private final UserDao userDao;
    private final SurveyDao surveyDao;


    @GetMapping("/")
    public ResponseEntity<List<SurveyEntity>> getAllSurveys() {
        return new ResponseEntity<>(surveyDao.findAll(), HttpStatus.OK);
    }

    @PostMapping("/status")
    public ResponseEntity<ResponseCheckStatus> checkStatus(@RequestBody RequestCheckStatus requestCheckStatus) {
        ResponseCheckStatus responseCheckStatus = new ResponseCheckStatus();


        switch (requestCheckStatus.getStatus()) {
            case "Admin":
                if (adminDao.isAdmin(requestCheckStatus.getLogin(), requestCheckStatus.getPassword())) {
                    responseCheckStatus.setStatus("Admin");
                    responseCheckStatus.setId(adminDao.findAdmin(requestCheckStatus.getLogin(),
                            requestCheckStatus.getPassword()).toString());
                } else {
                    responseCheckStatus.setStatus("NotAdmin");
                    responseCheckStatus.setId("-1");
                }
                break;
            case "Guest":
                UserEntity userEntity = new UserEntity();
                String identifier = userDao.save(userEntity);
                responseCheckStatus.setStatus("Guest");
                responseCheckStatus.setId(identifier);
                break;
            default:
                responseCheckStatus.setStatus("WrongRequest");
                responseCheckStatus.setId("-10");
        }
        return new ResponseEntity<>(responseCheckStatus, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ResponseCRUDOperation> createSurvey(@RequestBody RequestCreateSurvey requestCreateSurvey) {
        SurveyEntity surveyEntity = new SurveyEntity();
        surveyDao.save(surveyEntity, requestCreateSurvey);

        responseCRUDOperation.setAnswer("Survey Create");
        return new ResponseEntity<>(responseCRUDOperation, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseCRUDOperation> deleteSurvey(@PathVariable("id") int id) {
        surveyDao.deleteById(id);
        responseCRUDOperation.setAnswer("Survey was successfully deleted");

        return new ResponseEntity<>(responseCRUDOperation, HttpStatus.ACCEPTED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseCRUDOperation> updateSurvey(@PathVariable("id") int id,
                                                              @RequestBody RequestCreateSurvey requestCreateSurvey) {
        SurveyEntity surveyEntity = surveyDao.findById(id);
        surveyDao.save(surveyEntity, requestCreateSurvey);

        responseCRUDOperation.setAnswer("Survey was successfully updated");

        return new ResponseEntity<>(responseCRUDOperation, HttpStatus.OK);
    }
}
