package com.PJR.Quiz.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuizViewDto {

    private Long quizID;

    private String question;

    private String choice1;

    private String choice2;

    private String choice3;

    private String choice4;
}
