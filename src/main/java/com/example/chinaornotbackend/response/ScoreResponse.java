package com.example.chinaornotbackend.response;

import java.util.List;

import com.example.chinaornotbackend.dto.ScoreDto;
import com.example.chinaornotbackend.model.Score;

import lombok.Data;

@Data
public class ScoreResponse {
  private String name;
  private List<ScoreDto> scores;

  public ScoreResponse(String name, List<Score> scores) {
    this.name = name;
    this.scores = ScoreDto.convertToDto(scores);
  }
}
