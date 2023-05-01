package com.example.chinaornotbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chinaornotbackend.model.Score;
import com.example.chinaornotbackend.model.User;
import com.example.chinaornotbackend.request.ScoreRequest;
import com.example.chinaornotbackend.response.ScoreResponse;
import com.example.chinaornotbackend.service.ScoreService;
import com.example.chinaornotbackend.service.UserService;

@RestController
@RequestMapping("/api/scores")
public class ScoreController {
  @Autowired
  private ScoreService scoreService;

  @Autowired
  private UserService userService;

  @PostMapping
  public ResponseEntity<Long> createScore(@RequestBody ScoreRequest scoreRequest) {
    User user = userService.getUserByid(scoreRequest.getUserId());
    int totalScore = scoreRequest.getTotalScore();
    if (user == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    Score score = new Score();
    score.setUser(user);
    score.setTotalScore(totalScore);
    Long scoreId = scoreService.createScore(score);

    return new ResponseEntity<>(scoreId, HttpStatus.CREATED);
  }

  @GetMapping("/{user_id}")
  public ResponseEntity<ScoreResponse> getScoreByUserId(@PathVariable("user_id") Long userId) {
    String userName = userService.getUserByid(userId).getName();
    List<Score> scores = scoreService.getScoreByUserId(userId);
    if (scores.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    ScoreResponse scoreResponse = new ScoreResponse(userName, scores);

    return new ResponseEntity<>(scoreResponse, HttpStatus.OK);
  }

}
