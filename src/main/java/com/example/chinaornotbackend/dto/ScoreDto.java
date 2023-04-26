package com.example.chinaornotbackend.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.chinaornotbackend.model.Score;

import lombok.Data;

// DTO : Data Transfer Object
// データベースから取得したデータをAPIのレスポンスとして返す際に、データベースのエンティティを直接使用せず、DTOを介してデータを変換・伝達する。
@Data
public class ScoreDto {
  private int totalScore;

  public static List<ScoreDto> convertToDto(List<Score> scores) {
    if (scores == null || scores.isEmpty()) {
      return Collections.emptyList();
    }

    List<ScoreDto> scoreDtos = new ArrayList<>();
    for (Score score : scores) {
      ScoreDto scoreDto = new ScoreDto();
      scoreDto.setTotalScore(score.getTotalScore());
      scoreDtos.add(scoreDto);
    }
    return scoreDtos;
  }
}
