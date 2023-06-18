package com.PJR.Quiz.service;

import com.PJR.Quiz.dto.QuizViewDto;
import com.PJR.Quiz.entity.QuizChoice;

import java.util.List;

public interface QuizChoiceService {

    QuizChoice addQuiz(QuizChoice quizChoice);


    QuizChoice getQuiz(long quizID);

    QuizViewDto getQuizOne(long quizID);

}
