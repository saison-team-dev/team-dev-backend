package com.example.chinaornotbackend.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasSize;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.chinaornotbackend.response.QuizResponse;
import com.example.chinaornotbackend.service.QuizService;

@WebMvcTest(QuizController.class)
public class QuizControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private QuizService quizService;

  /**
   * @throws Exception
   */
  @Test
  public void getQuizzes_shouldReturnQuizzes() throws Exception {
    List<QuizResponse> quizzes = new ArrayList<>();
    for(int i = 0; i < 10; i++) {
      QuizResponse quiz = new QuizResponse((long) i, "quiz" + i, "answer" + i, "imageUrl" + i);
      quizzes.add(quiz);
    }
    when(quizService.getQuizzes()).thenReturn(quizzes);

    mockMvc.perform(get("/api/quizzes")
      .contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$[0].id").value(0L))
      .andExpect(jsonPath("$[0].question").value("quiz0"))
      .andExpect(jsonPath("$[0].answer").value("answer0"))
      .andExpect(jsonPath("$[0].imageUrl").value("imageUrl0"))
      .andExpect(jsonPath("$", hasSize(10)));
  }
}