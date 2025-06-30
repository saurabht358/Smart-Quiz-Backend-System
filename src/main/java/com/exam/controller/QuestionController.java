package com.exam.controller;

import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;
import com.exam.service.QuestionService;
import com.exam.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;

    @PostMapping("/")
    public ResponseEntity<?> add(@RequestBody Question question){
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }

    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody Question question){
        return ResponseEntity.ok(this.questionService.updateQuestion(question));
    }

    @GetMapping("/quiz/{qid}")
    public ResponseEntity<?> getAllByQuiz(@PathVariable Long qid){
//        Quiz quiz = new Quiz();
//        quiz.setqId(qid);
//        Set<Question> questionSet = this.questionService.getQuestionsOfQuiz(quiz);
//        return ResponseEntity.ok(questionSet);

        Quiz quiz = this.quizService.getQuiz(qid);
        Set<Question> questions = quiz.getQuestions();
        List list = new ArrayList(questions);
        if(list.size() > Integer.parseInt(quiz.getNumberOfQuestions())){
            list = list.subList(0,Integer.parseInt(quiz.getNumberOfQuestions()+1));
        }
        Collections.shuffle(list);

        return ResponseEntity.ok(list);

    }
    @GetMapping("/{qid}")
    public Question getQuestion(@PathVariable("qid")Long qid){
        return this.questionService.getQuestion(qid);
    }

    @DeleteMapping("/{qid}")
    public void delete(@PathVariable("qid")Long qid){
        this.questionService.deleteQuestion(qid);
    }




}
