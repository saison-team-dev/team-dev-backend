package com.example.chinaornotbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chinaornotbackend.model.QuizCategory;
import com.example.chinaornotbackend.repository.QuizCategoryRepository;


@Service
public class QuizCategoryServiceImpl implements QuizCategoryService {
  @Autowired
  private QuizCategoryRepository quizCategoryRepository;

  @Override
  public List<QuizCategory> getQuizCategories() {
    List<QuizCategory> quizCategories = quizCategoryRepository.findAll();
    return quizCategories;
  }
}
