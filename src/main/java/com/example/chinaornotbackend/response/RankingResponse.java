package com.example.chinaornotbackend.response;

import lombok.Data;
import com.example.chinaornotbackend.model.User;
import com.example.chinaornotbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class RankingResponse {
  @Autowired
  UserService userService;

  private Long userId;
  private String name;
  private int totalScore;
  private int correctRate;
  private int rank;

  public RankingResponse(
		  Long userId,
		  int totalScore,
		  int correctRate,
		  int rank
		  ) {
	  this.userId = userId;
	  this.name = userService.getUserByid(userId).getName();
	  this.totalScore = totalScore;
	  this.correctRate = correctRate;
	  this.rank = rank;
  }
}
