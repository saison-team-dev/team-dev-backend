package com.example.chinaornotbackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    Pageable pageable = PageRequest.of(0, 10);
    List<Quiz> quizzes = quizRepository.findAllWithAnswers(pageable);
    /*
     * 以下の形式でクイズを取得する
     * [
     * {
     * "id": 1,
     * "question": "クイズの問題文",
     * "answer": "クイズの回答"
     * },
     * {
     * "id": 2,
     * "question": "クイズの問題文",
     * "answer": "クイズの回答"
     * }
     * ]
     */

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
