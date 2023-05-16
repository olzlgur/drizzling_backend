package com.example.demo.quiz.controller;

import com.example.demo.global.response.CommonResponse;
import com.example.demo.global.response.ResponseService;
import com.example.demo.quiz.dto.CheckAnswerRequestDto;
import com.example.demo.quiz.dto.QuizAnswerResponseDto;
import com.example.demo.quiz.dto.QuizResponseDto;
import com.example.demo.quiz.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuizController {

    private final ResponseService responseService;
    private final QuizService quizService;

    @GetMapping("/get/{category}")
    public QuizResponseDto getQuiz(@PathVariable("category") String category) {
        return quizService.getQuiz(category);
    }

    @PostMapping("/check")
    public QuizAnswerResponseDto checkAnswer(@RequestBody CheckAnswerRequestDto checkAnswerRequestDto) {
        QuizAnswerResponseDto quizResponseDto = new QuizAnswerResponseDto();
        quizResponseDto.setAnswer(quizService.checkQuizAnswer(checkAnswerRequestDto));
        return quizResponseDto;
    }

    @DeleteMapping("/resetDate")
    public void resetDate() {
        quizService.deleteAllDate();
        return ;
    }

}
