package com.example.chinaornotbackend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.chinaornotbackend.model.Answer;
import com.example.chinaornotbackend.model.Quiz;
import com.example.chinaornotbackend.repository.AnswerRepository;
import com.example.chinaornotbackend.repository.QuizRepository;
import com.example.chinaornotbackend.util.JsonFileReader;
import com.fasterxml.jackson.core.type.TypeReference;

@Component
public class DataLoader implements ApplicationRunner {
  @Autowired
  private QuizRepository quizRepository;

  @Autowired
  private AnswerRepository answerRepository;

  @Override
  public void run(ApplicationArguments args) {
    List<Answer> answers = JsonFileReader.readJsonFile("src/main/resources/data/answers.json",
        new TypeReference<List<Answer>>() {
        });
    answers.stream()
        .filter(answer -> answerRepository.findByAnswer(answer.getAnswer()).isEmpty())
        .forEach(answer -> answerRepository.save(answer));

    List<Quiz> quizzes = JsonFileReader.readJsonFile("src/main/resources/data/quizzes.json",
        new TypeReference<List<Quiz>>() {
        });
    quizzes.stream()
        .filter(quiz -> quizRepository.findByQuestion(quiz.getQuestion()).isEmpty())
        .forEach(quiz -> quizRepository.save(quiz));

    for (Quiz quiz : quizzes) {
      Answer relatedAnswer = answers.stream()
          .filter(answer -> answer.getId() == quiz.getAnswer().getId())
          .findFirst()
          .orElse(null);

      if (relatedAnswer != null) {
        quiz.setAnswer(relatedAnswer);
      }
    }
  }
}
