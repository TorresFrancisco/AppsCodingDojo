package com.francisco.dojooverflow.services;

import com.francisco.dojooverflow.models.Answer;
import com.francisco.dojooverflow.repository.AnswerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository){
        this.answerRepository = answerRepository;
    }

//    public List<Answer> findAnswer(Answer answer){
//        return answerRepository.findByAnswersNotContaining(answer);
//    }

    public List<Answer> allAnswers() {
        return answerRepository.findAll();
    }

    public Answer createAnswer(Answer c) {
        return answerRepository.save(c);
    }

    public Answer findAnswer(Long id) {
        Optional<Answer> optionalAnswer = answerRepository.findById(id);
        if(optionalAnswer.isPresent()){
            return optionalAnswer.get();
        } else {
            return null;
        }
    }
}
