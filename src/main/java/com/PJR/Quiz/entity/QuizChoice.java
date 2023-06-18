package com.PJR.Quiz.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NotFound;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "quizChoice")
public class QuizChoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long quizID;

    @Column(nullable = false, unique = true, columnDefinition = "VARCHAR(255) CHARACTER SET UTF8")
    private String question;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) CHARACTER SET UTF8")
    private Long correct;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) CHARACTER SET UTF8")
    private String choice1;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) CHARACTER SET UTF8")
    private String choice2;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) CHARACTER SET UTF8")
    private String choice3;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) CHARACTER SET UTF8")
    private String choice4;


}
