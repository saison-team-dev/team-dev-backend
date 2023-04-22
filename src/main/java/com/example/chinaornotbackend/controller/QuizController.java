package com.example.chinaornotbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chinaornotbackend.response.QuizResponse;
import com.example.chinaornotbackend.service.QuizService;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {
  @Autowired
  private QuizService quizService;

  @GetMapping
  public ResponseEntity<List<QuizResponse>> getQuizzes() {
    List<QuizResponse> quizzes = quizService.getQuizzes();
    return new ResponseEntity<>(quizzes, HttpStatus.OK);
  }

}
