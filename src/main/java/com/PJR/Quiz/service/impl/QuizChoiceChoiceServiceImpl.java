package com.PJR.Quiz.service.impl;

import com.PJR.Quiz.dto.QuizViewDto;
import com.PJR.Quiz.entity.QuizChoice;
import com.PJR.Quiz.repository.QuizRepository;
import com.PJR.Quiz.service.QuizChoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizChoiceChoiceServiceImpl implements QuizChoiceService {

    private final QuizRepository quizRepository;

    @Autowired
    public QuizChoiceChoiceServiceImpl(QuizRepository quizRepository){
        this.quizRepository=quizRepository;
    }
    @Override
    public QuizChoice addQuiz(QuizChoice quizChoice) {
        QuizChoice quizChoice1 = quizRepository.save(quizChoice);
        return quizChoice1;
    }

    @Override
    public QuizChoice getQuiz(long quizID) {
        System.out.println("ggggggggggg"+quizID);
        QuizChoice quizChoice= quizRepository.findByQuizID(quizID);

        return quizChoice;
    }


    @Override
    public QuizViewDto getQuizOne(long quizID) {
        QuizChoice quizChoice = quizRepository.getById(quizID);

        QuizViewDto quizViewDto = new QuizViewDto();
        quizViewDto.setQuizID(quizChoice.getQuizID());
        quizViewDto.setQuestion(quizChoice.getQuestion());
        quizViewDto.setChoice1(quizChoice.getChoice1());
        quizViewDto.setChoice2(quizChoice.getChoice2());
        quizViewDto.setChoice3(quizChoice.getChoice3());
        quizViewDto.setChoice4(quizChoice.getChoice4());

        return quizViewDto;
    }
}
