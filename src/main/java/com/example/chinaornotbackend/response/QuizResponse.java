package com.example.chinaornotbackend.response;

import lombok.Data;

@Data
public class QuizResponse {
  private Long id;
  private String question;
  private String answer;

  public QuizResponse(Long id, String question, String answer) {
    this.id = id;
    this.question = question;
    this.answer = answer;
  }
}
