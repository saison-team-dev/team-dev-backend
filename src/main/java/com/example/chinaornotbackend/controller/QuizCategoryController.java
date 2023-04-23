package com.example.chinaornotbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// import com.example.chinaornotbackend.model.QuizCategory;

import java.io.IOException;
import java.nio.file.Paths;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;



@RestController
@RequestMapping("/api/quiz_categories")
public class QuizCategoryController {
  
  @GetMapping
  private String getQuizCategory() throws JsonProcessingException, IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    JsonNode json = objectMapper.readTree(Paths.get("src/main/resources/data/quizCategories.json").toFile());
    return json.toString();
  }
}