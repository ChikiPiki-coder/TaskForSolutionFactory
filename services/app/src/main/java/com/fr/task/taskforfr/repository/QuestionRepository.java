package com.fr.task.taskforfr.repository;

import com.fr.task.taskforfr.entity.QuestionEntity;
import com.fr.task.taskforfr.entity.SurveyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionEntity, Integer> {
    QuestionEntity findQuestionEntityByQuestionAndIdSurvey(String question, SurveyEntity idSurvey);
    QuestionEntity findById(int id);
    List<QuestionEntity> findAllByIdSurvey(SurveyEntity idSurvey);
}
