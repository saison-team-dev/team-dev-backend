package com.example.chinaornotbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/quiz_categories")
public class QuizCategoryController {
        
        @GetMapping("/")
        private String getQuizCategories() {
                String json = "json";
                return json;
        }
}
