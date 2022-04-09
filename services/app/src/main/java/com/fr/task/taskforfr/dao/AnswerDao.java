package com.fr.task.taskforfr.dao;

import com.fr.task.taskforfr.entity.AnswerToQuestionEntity;
import com.fr.task.taskforfr.models.RequestSaveResult;
import com.fr.task.taskforfr.repository.AnswerToQuestionRepository;
import com.fr.task.taskforfr.repository.QuestionRepository;
import com.fr.task.taskforfr.repository.SurveyRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor
public class AnswerDao {
    private final AnswerToQuestionRepository answerToQuestionRepository;
    private final QuestionRepository questionRepository;
    private final SurveyRepository surveyRepository;

    public void save(List<RequestSaveResult> requestSaveResultList,
                     int idSurvey,
                     String identifierUser) {
        for (var requestSaveResult : requestSaveResultList) {
            for (var answer : requestSaveResult.getAnswer()) {
                AnswerToQuestionEntity answerToQuestionEntity = new AnswerToQuestionEntity();

                answerToQuestionEntity.setIdQuestion(questionRepository.findById(
                        questionRepository.findQuestionEntityByQuestionAndIdSurvey(
                                requestSaveResult.getQuestion(),
                                surveyRepository.findById(idSurvey)
                        ).getId().intValue()
                ));

                answerToQuestionEntity.setAnswer(answer);
                answerToQuestionEntity.setIdSurvey(surveyRepository.findById(idSurvey));
                answerToQuestionEntity.setIdentifierUser(identifierUser);
                answerToQuestionRepository.save(answerToQuestionEntity);
            }
        }
    }

    public List<AnswerToQuestionEntity> getResultByIdSurvey(int idSurvey) {
        return answerToQuestionRepository.findAllByIdSurvey(surveyRepository.findById(idSurvey));
    }
}
