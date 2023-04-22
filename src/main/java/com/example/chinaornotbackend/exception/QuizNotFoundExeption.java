package com.example.chinaornotbackend.exception;

public class QuizNotFoundExeption extends RuntimeException {
  public QuizNotFoundExeption(String message) {
    super(message);
  }
}
