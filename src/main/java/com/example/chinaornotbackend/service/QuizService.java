package com.example.chinaornotbackend.service;

import java.util.List;

import com.example.chinaornotbackend.model.Quiz;
import com.example.chinaornotbackend.response.QuizResponse;

public interface QuizService {
  List<QuizResponse> getQuizzes(int limit);

  QuizResponse createQuiz(Quiz quiz);
}
