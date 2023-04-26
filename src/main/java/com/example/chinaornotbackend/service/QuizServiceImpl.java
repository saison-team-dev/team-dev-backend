package com.example.chinaornotbackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chinaornotbackend.exception.QuizNotFoundExeption;
import com.example.chinaornotbackend.model.Quiz;
import com.example.chinaornotbackend.repository.QuizRepository;
import com.example.chinaornotbackend.response.QuizResponse;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
  private QuizRepository quizRepository;

  @Override
  public List<QuizResponse> getQuizzes() {
    List<Quiz> quizzes = quizRepository.findAllWithAnswers();

     List<QuizResponse> quizResponses = new ArrayList<>();
    for (Quiz quiz : quizzes) {
      QuizResponse quizResponse = new QuizResponse(quiz.getId(), quiz.getQuestion(), quiz.getAnswer().getAnswer(), quiz.getImageUrl());
      quizResponses.add(quizResponse);
    }

    if (quizzes.isEmpty()) {
      throw new QuizNotFoundExeption("クイズが見つかりませんでした。");
    } else {
      return quizResponses;
    }
  }
}
