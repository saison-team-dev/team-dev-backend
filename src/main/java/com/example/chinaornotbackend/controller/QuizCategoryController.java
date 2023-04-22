package com.example.chinaornotbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chinaornotbackend.model.QuizCategory;



@RestController
@RequestMapping("api/quiz_categories")
public class QuizCategoryController {
  
  @GetMapping("/")
  private String getQuizCategory() {
    return "bean";
  }
}