package com.fr.task.taskforfr.dao;

import com.fr.task.taskforfr.entity.AnswerToQuestionEntity;
import com.fr.task.taskforfr.entity.SurveyEntity;
import com.fr.task.taskforfr.models.RequestCreateSurvey;
import com.fr.task.taskforfr.repository.AnswerToQuestionRepository;
import com.fr.task.taskforfr.repository.SurveyRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
@AllArgsConstructor
public class SurveyDao {
    private final SurveyRepository surveyRepository;
    private final AnswerToQuestionRepository answerToQuestionRepository;


    public SurveyEntity findById(int id) {
        return surveyRepository.findById(id);
    }

    public List<SurveyEntity> findAll() {
        return surveyRepository.findAll();
    }

    public void save(SurveyEntity surveyEntity, RequestCreateSurvey requestCreateSurvey) {
        surveyEntity.setName(requestCreateSurvey.getName());
        surveyEntity.setStart(requestCreateSurvey.getStart());
        surveyEntity.setFinish(requestCreateSurvey.getFinish());
        surveyEntity.setDescription(requestCreateSurvey.getDescription());

        surveyRepository.save(surveyEntity);
    }

    public void deleteById(int id) {
        surveyRepository.deleteById(id);
    }

    public List<SurveyEntity> getAllByIdentifierUser(String identifier) {
        List<SurveyEntity> surveyEntities = new ArrayList<>();

        List<AnswerToQuestionEntity> answerToQuestionEntities = answerToQuestionRepository.findAllByIdentifierUser(identifier);

        for (AnswerToQuestionEntity answerToQuestionEntity : answerToQuestionEntities) {
            if (!surveyEntities.contains(answerToQuestionEntity.getIdSurvey())) {
                surveyEntities.add(answerToQuestionEntity.getIdSurvey());
            }
        }

        return surveyEntities;
    }
}
