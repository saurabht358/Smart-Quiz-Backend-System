package com.exam.controller;

import com.exam.model.exam.Quiz;
import com.exam.service.QuestionService;
import com.exam.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/")
    public ResponseEntity<?> addQuiz(@RequestBody Quiz quiz){
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }

    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody Quiz quiz){
        return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
    }

    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.quizService.getAllQuiz());
    }

    @GetMapping("/{quizId}")
    public ResponseEntity<?> getQuiz(@PathVariable("quizId")Long quizId){
        return ResponseEntity.ok(this.quizService.getQuiz(quizId));
    }

    @DeleteMapping("/{quizId}")
    public void deleteQuiz(@PathVariable("quizId")Long quizId){
        this.quizService.deleteQuiz(quizId);
    }

}
