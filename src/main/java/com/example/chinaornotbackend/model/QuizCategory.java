package com.example.chinaornotbackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "quiz_categories")
public class QuizCategory {

  @Id
  private Long id;

  @Column(nullable = false)
  private String name;
}
