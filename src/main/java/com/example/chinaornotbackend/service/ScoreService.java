package com.example.chinaornotbackend.service;

import java.util.List;

import com.example.chinaornotbackend.model.Score;

public interface ScoreService {
  Long createScore(Score score);

  List<Score> getScoreByUserId(Long userId);
}
