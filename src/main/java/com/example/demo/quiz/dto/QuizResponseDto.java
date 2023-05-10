package com.example.demo.quiz.dto;

import com.example.demo.quiz.domain.Quiz;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
public class QuizResponseDto {

    @NotNull
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String content;

    @NotNull
    private String quiz;

    @NotNull
    private String seletion1;

    @NotNull
    private String seletion2;

    @NotNull
    private String seletion3;

    @NotNull
    private String seletion4;

    @Builder
    public static QuizResponseDto register(Quiz quiz){
        QuizResponseDto quizResponseDto = new QuizResponseDto();
        quizResponseDto.setQuiz(quiz.getQuiz());
        quizResponseDto.setId(quiz.getId());
        quizResponseDto.setTitle(quiz.getTitle());
        quizResponseDto.setContent(quiz.getContent());
        quizResponseDto.setSeletion1(quiz.getSeletion1());
        quizResponseDto.setSeletion2(quiz.getSeletion2());
        quizResponseDto.setSeletion3(quiz.getSeletion3());
        quizResponseDto.setSeletion4(quiz.getSeletion4());

        return quizResponseDto;
    }
}
