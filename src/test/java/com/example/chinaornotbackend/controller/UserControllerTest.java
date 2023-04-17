package com.example.chinaornotbackend.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.chinaornotbackend.model.User;
import com.example.chinaornotbackend.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(UserController.class)
public class UserControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockBean
  private UserService userService;

  @Test
  public void createUser_shouldReturnCreated() throws Exception {
    // モックオブジェクトのメソッドの戻り値を設定
    when(userService.createUser(any(User.class))).thenReturn(1L);

    User user = new User();
    user.setName("test");

    /*
     * objectMapper: JSONオブジェクトをJavaオブジェクトに変換するためのクラス
     * writeValueAsString: JavaオブジェクトをJSON文字列に変換する
     */
    String requestBody = objectMapper.writeValueAsString(user);

// POSTリクエストをAPIエンドポイントに送信するためのモックオブジェクトを作成
mockMvc.perform(post("/api/users")
  // リクエストボディの形式をJSONに設定
  .contentType(MediaType.APPLICATION_JSON)
  // リクエストボディを設定
  .content(requestBody))
  // HTTPステータスコード201を期待
  .andExpect(status().isCreated())
  // レスポンスのidフィールドの値が1Lであることを期待
  .andExpect(jsonPath("$").value(1L));
  }

  @Test
  public void getUserById_shouldReturnUser() throws Exception {
    User user = new User();
    user.setId(1L);
    user.setName("test");
    when(userService.getUserByid(1L)).thenReturn(user);

    mockMvc.perform(get("/api/users/1"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.id").value(1L))
      .andExpect(jsonPath("$.name").value("test"));
  }
}
