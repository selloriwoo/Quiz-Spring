package com.PJR.Quiz.controller;

import com.PJR.Quiz.dto.QuizIsTrue;
import com.PJR.Quiz.dto.QuizViewDto;
import com.PJR.Quiz.entity.QQuizChoice;
import com.PJR.Quiz.entity.QuizChoice;
import com.PJR.Quiz.service.QuizChoiceService;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/quiz")
public class QuizController {

    private final QuizChoiceService quizChoiceService;

    @Autowired
    public QuizController(QuizChoiceService quizChoiceService){
        this.quizChoiceService=quizChoiceService;
    }

    @PersistenceContext
    EntityManager entityManager;




    @GetMapping("/createQuizForm") //index
    public String createQuizForm(HttpServletRequest request){
        HttpSession session = request.getSession();
        String sessionAttr= (String) session.getAttribute("user_id");
        System.out.println("세션"+sessionAttr);
        if(sessionAttr==null){
            System.out.println("널값확인");
            return "loginForm";
        }
        return "createQuizForm";
    }

    @PostMapping("/createQuiz")
    public String createQuizForm(QuizChoice quizChoice, HttpServletRequest request){
        HttpSession session = request.getSession();
        String sessionAttr= (String) session.getAttribute("user_id");
        if(sessionAttr==null){
            System.out.println("널값확인");
            return "loginForm";
        }


        QuizChoice quizChoice1= quizChoiceService.addQuiz(quizChoice);
        return "index";
    }


    @GetMapping("/quizView")
    public String quizView(Model model){

        JPAQueryFactory query = new JPAQueryFactory(entityManager);
        QQuizChoice qQuizChoice= QQuizChoice.quizChoice;


        List<Long> quizIDMaxList= query
                .select(qQuizChoice.quizID.max())
                .from(qQuizChoice)
                .fetch();

        Long quizIDMax= quizIDMaxList.get(0); //퀴즈 갯수

        long randomNum=  (long) (Math.random()*quizIDMax+1);
        System.out.println("최대 퀴즈ID값"+quizIDMax);
        System.out.println("랜덤 퀴즈ID값"+randomNum);

        QuizChoice quizChoice= quizChoiceService.getQuiz(randomNum);
        model.addAttribute("quizView", quizChoice);

        return "quizView";
    }

    @GetMapping("/getQuizOne")
    public ResponseEntity<QuizViewDto> getQuizOne(){

        JPAQueryFactory query = new JPAQueryFactory(entityManager);
        QQuizChoice qQuizChoice= QQuizChoice.quizChoice;


        List<Long> quizIDMaxList= query
                .select(qQuizChoice.quizID.max())
                .from(qQuizChoice)
                .fetch();

        Long quizIDMax= quizIDMaxList.get(0); //퀴즈 갯수
        long randomNum=  (long) (Math.random()*quizIDMax+1);

        QuizViewDto QuizViewDto = quizChoiceService.getQuizOne(randomNum);

        return ResponseEntity.status(HttpStatus.OK).body(QuizViewDto);
    }

    @PostMapping("/isTrue")
    public ResponseEntity<String> isTrue(@RequestBody QuizIsTrue quizIsTrue){
        long quizId= quizIsTrue.getQuizID();
        long answer =quizIsTrue.getAnswer();
        System.out.println("퀴즈아이디:"+quizId+" 퀴즈 응답:"+answer);
        long correct= quizChoiceService.getQuiz(quizId).getCorrect();

        if(answer==correct)
            return ResponseEntity.status(HttpStatus.OK).body("true");

        return ResponseEntity.status(HttpStatus.OK).body("false");
    }

    @PostMapping("/quizAnswer")
    public String selectAnswer(@RequestParam("correct") long answerCorrect, @RequestParam("quizID") long answerQuizID, Model model){
        System.out.println("가져온 정답:"+answerCorrect);
        System.out.println("가져온 문제Id:"+answerQuizID);
        QuizChoice quizChoice = quizChoiceService.getQuiz(answerQuizID);
        System.out.println("문제 정답:"+quizChoice.getCorrect());
        model.addAttribute("quizCorrect", quizChoice.getCorrect());
        model.addAttribute("userCorrect", answerCorrect);

        return "quizAnswer";
    }

    @GetMapping("/quizAnswer")
    public String selectAnswer(){
        return "quizAnswer";
    }




}
