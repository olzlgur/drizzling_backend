package com.example.demo.quiz.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class QuizAnswerResponseDto {

    @NotNull
    Boolean answer;
}
