package com.fr.task.taskforfr.controllers;

import com.fr.task.taskforfr.dao.*;
import com.fr.task.taskforfr.entity.QuestionEntity;
import com.fr.task.taskforfr.models.Question;
import com.fr.task.taskforfr.models.ResponseCRUDOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/survey/{idSurvey}/questions")
public class QuestionController {
    private final ResponseCRUDOperation responseCRUDOperation;
    private final QuestionDao questionDao;

    @PostMapping("/")
    public ResponseEntity<ResponseCRUDOperation> createQuestion(@PathVariable("idSurvey") int id,
                                                                @RequestBody Question question) {

        QuestionEntity questionEntity = new QuestionEntity();
        questionDao.save(questionEntity, question, id);

        responseCRUDOperation.setAnswer("Question created");
        return new ResponseEntity<>(responseCRUDOperation, HttpStatus.CREATED);
    }


    @PatchMapping("/{idQuestion}")
    public ResponseEntity<ResponseCRUDOperation> updateQuestion(@PathVariable("idSurvey") int id_survey,
                                                                @PathVariable("idQuestion") int id_question,
                                                                @RequestBody Question question) {
        QuestionEntity questionEntity = questionDao.findById(id_question);
        questionDao.save(questionEntity, question, id_survey);

        responseCRUDOperation.setAnswer("Question Update was successful");
        return new ResponseEntity<>(responseCRUDOperation, HttpStatus.OK);
    }


    @DeleteMapping("/{idQuestion}")
    public ResponseEntity<ResponseCRUDOperation> deleteQuestion(@PathVariable("idQuestion") int idQuestion) {


        questionDao.deleteById(idQuestion);
        responseCRUDOperation.setAnswer("Question Delete was successful");
        return new ResponseEntity<>(responseCRUDOperation, HttpStatus.ACCEPTED);
    }


}
