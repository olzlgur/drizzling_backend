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
    private String selection1;

    @NotNull
    private String selection2;

    @NotNull
    private String selection3;

    @NotNull
    private String selection4;

    @NotNull
    private int answer;

    @Builder
    public static QuizResponseDto register(Quiz quiz){
        QuizResponseDto quizResponseDto = new QuizResponseDto();
        quizResponseDto.setQuiz(quiz.getQuiz());
        quizResponseDto.setId(quiz.getId());
        quizResponseDto.setTitle(quiz.getTitle());
        quizResponseDto.setContent(quiz.getContent());
        quizResponseDto.setSelection1(quiz.getSeletion1());
        quizResponseDto.setSelection2(quiz.getSeletion2());
        quizResponseDto.setSelection3(quiz.getSeletion3());
        quizResponseDto.setSelection4(quiz.getSeletion4());
        quizResponseDto.setAnswer(quiz.getAnswer());

        return quizResponseDto;
    }
}
