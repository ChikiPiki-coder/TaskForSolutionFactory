package com.fr.task.taskforfr.repository;

import com.fr.task.taskforfr.entity.AnswerToQuestionEntity;
import com.fr.task.taskforfr.entity.SurveyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AnswerToQuestionRepository extends JpaRepository<AnswerToQuestionEntity,Integer> {
        List<AnswerToQuestionEntity> findAllByIdentifierUser(String identifierUser);
        List<AnswerToQuestionEntity> findAllByIdSurvey(SurveyEntity idSurvey);
}
