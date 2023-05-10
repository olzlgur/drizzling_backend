package com.example.demo.quiz.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CheckAnswerRequestDto {

    @NotNull
    private Long id;

    @NotNull
    private int answer;

}
