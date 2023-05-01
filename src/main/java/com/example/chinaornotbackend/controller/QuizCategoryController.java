package com.example.chinaornotbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;


import com.example.chinaornotbackend.model.QuizCategory;
import com.example.chinaornotbackend.service.QuizCategoryService;



@RestController
@RequestMapping("/api/quiz_categories")
public class QuizCategoryController {
  @Autowired
  private QuizCategoryService quizCategoryService;

  @GetMapping
  private ResponseEntity<List<QuizCategory>> getQuizCategory() {
    List<QuizCategory> quizCategories = quizCategoryService.getQuizCategories();
    return new ResponseEntity<>(quizCategories, HttpStatus.OK);
  }
}