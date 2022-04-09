package com.fr.task.taskforfr.dao;

import com.fr.task.taskforfr.entity.AnswerOptionsEntity;
import com.fr.task.taskforfr.entity.QuestionEntity;
import com.fr.task.taskforfr.models.Question;
import com.fr.task.taskforfr.repository.AnswerOptionsRepository;
import com.fr.task.taskforfr.repository.QuestionRepository;
import com.fr.task.taskforfr.repository.SurveyRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor
public class QuestionDao {
    private final SurveyRepository surveyRepository;
    private final QuestionRepository questionRepository;
    private final AnswerOptionsRepository answerOptionsRepository;

    public void deleteById(int id){
        questionRepository.deleteById(id);
        answerOptionsRepository.deleteAllByIdQuestion(id);
    }

    public QuestionEntity findById(int id){
        return questionRepository.findById(id);
    }

    public void save(QuestionEntity questionEntity, Question question, int idSurvey) {
        questionEntity.setQuestion(question.getQuestion());
        questionEntity.setTypeQuestion(question.getTypeQuestion().name());
        questionEntity.setIdSurvey(surveyRepository.findById(idSurvey));

        questionRepository.save(questionEntity);

        QuestionEntity questionEnt = questionRepository
                .findQuestionEntityByQuestionAndIdSurvey(question.getQuestion(), surveyRepository.findById(idSurvey));
        saveAnswerOptions(question, questionEnt);
    }
    private void saveAnswerOptions(Question question, QuestionEntity questionEntity) {
        List<String> answerOptions = question.getAnswerOptionsList();

        for (int i = 0; i < answerOptions.size(); i++) {
            AnswerOptionsEntity answerOptionsEntity = new AnswerOptionsEntity();

            answerOptionsEntity.setAnswerOptions(answerOptions.get(i));
            answerOptionsEntity.setNumberAnswer(i + 1);
            answerOptionsEntity.setIdQuestion(findById(questionEntity.getId()));
            answerOptionsRepository.save(answerOptionsEntity);
        }

    }

}
