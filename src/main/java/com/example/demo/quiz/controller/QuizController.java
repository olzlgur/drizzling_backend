package com.example.demo.quiz.controller;

import com.example.demo.global.response.CommonResponse;
import com.example.demo.global.response.ResponseService;
import com.example.demo.quiz.dto.CheckAnswerRequestDto;
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
    public CommonResponse<Object> getQuiz(@PathVariable("category") String category) {
        return responseService.getSuccessResponse("문제 반환 성공", quizService.getQuiz(category));
    }

    @PostMapping("/check")
    public CommonResponse<Object> checkAnswer(@RequestBody CheckAnswerRequestDto checkAnswerRequestDto) {
        return responseService.getSuccessResponse("채점 완료", quizService.checkQuizAnswer(checkAnswerRequestDto));
    }

    @DeleteMapping("/resetDate")
    public CommonResponse<Object> resetDate() {
        quizService.deleteAllDate();
        return responseService.getSuccessResponse("날짜 리셋", null);
    }

}
