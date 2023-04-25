package com.example.chinaornotbackend.service;

import java.util.List;


import com.example.chinaornotbackend.response.QuizResponse;

public interface QuizService {
  List<QuizResponse> getQuizzes();
}
