package com.PJR.Quiz.repository;

import com.PJR.Quiz.entity.QuizChoice;
import com.PJR.Quiz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface QuizRepository extends JpaRepository<QuizChoice, Long> {

    QuizChoice findByQuizID(long quizID);


}
