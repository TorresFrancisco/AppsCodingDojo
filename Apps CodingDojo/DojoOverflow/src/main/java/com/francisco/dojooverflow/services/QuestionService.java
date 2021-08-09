package com.francisco.dojooverflow.services;

import com.francisco.dojooverflow.models.Question;
import com.francisco.dojooverflow.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }

    public List<Question> allQuestions() {
        return questionRepository.findAll();
    }

    public Question createQuestion(Question c) {
        return questionRepository.save(c);
    }

    public Question findQuestion(Long id) {
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        if(optionalQuestion.isPresent()){
            return optionalQuestion.get();
        } else {
            return null;
        }
    }
}
