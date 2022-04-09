package com.fr.task.taskforfr.controllers;

import com.fr.task.taskforfr.dao.*;
import com.fr.task.taskforfr.entity.AnswerToQuestionEntity;
import com.fr.task.taskforfr.entity.SurveyEntity;
import com.fr.task.taskforfr.models.RequestSaveResult;
import com.fr.task.taskforfr.models.ResponseCRUDOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/answer")
public class AnswerController {

    private final ResponseCRUDOperation responseCRUDOperation;

    private final SurveyDao surveyDao;
    private final AnswerDao answerDao;


    @PostMapping("/{idSurvey}/{identifierUser}/result")
    public ResponseEntity<ResponseCRUDOperation> saveSurveyResult(@PathVariable("idSurvey") int idSurvey,
                                                                  @PathVariable("identifierUser") String identifierUser,
                                                                  @RequestBody List<RequestSaveResult> requestSaveResultList) {

        answerDao.save(requestSaveResultList, idSurvey, identifierUser);

        responseCRUDOperation.setAnswer("Save answer was successful");
        return new ResponseEntity<>(responseCRUDOperation, HttpStatus.CREATED);
    }

    @GetMapping("/result-surveys/{identifier}")
    public ResponseEntity<List<SurveyEntity>> getCompletedSurveys(@PathVariable("identifier") String identifier) {
        return new ResponseEntity<>(surveyDao.getAllByIdentifierUser(identifier), HttpStatus.OK);
    }

    @GetMapping("/{idSurvey}/result")
    public ResponseEntity<List<AnswerToQuestionEntity>> getResultSurvey(@PathVariable("idSurvey") int idSurvey) {
        return new ResponseEntity<>(answerDao.getResultByIdSurvey(idSurvey), HttpStatus.OK);
    }

}
