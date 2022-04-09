package com.fr.task.taskforfr.repository;

import com.fr.task.taskforfr.entity.AnswerOptionsEntity;
import com.fr.task.taskforfr.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerOptionsRepository extends JpaRepository<AnswerOptionsEntity,Integer> {
    void deleteAllById(int id);
    void deleteAllByIdQuestion(int id);

    List<AnswerOptionsEntity> findAllByIdQuestion(QuestionEntity idQuestion);
}
