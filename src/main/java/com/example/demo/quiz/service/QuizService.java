package com.example.demo.quiz.service;

import com.example.demo.quiz.domain.Quiz;
import com.example.demo.quiz.dto.CheckAnswerRequestDto;
import com.example.demo.quiz.dto.QuizResponseDto;
import com.example.demo.quiz.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuizService {
    private final QuizRepository quizRepository;

    @Transactional
    public QuizResponseDto getQuiz(String category) {
        LocalDate time = LocalDate.now();
        Optional<Quiz> optionalQuiz = quizRepository.findByDateAndCategory(time, category);

        if (optionalQuiz.isPresent()) {
            return QuizResponseDto.register(optionalQuiz.get());
        }

        Quiz quiz = quizRepository.getQuiz(category);
        quiz.setDate(time);

        return QuizResponseDto.register(quiz);
    }

    public Boolean checkQuizAnswer(CheckAnswerRequestDto checkAnswerRequestDto){
        Quiz quiz = quizRepository.findById(checkAnswerRequestDto.getId());
        Boolean answer = checkAnswerRequestDto.getAnswer() == quiz.getAnswer();

        return answer;
    }

    @Transactional
    public void deleteAllDate() {
        List<Quiz> quizList = quizRepository.findAll();

        for (Quiz quiz : quizList){
            quiz.resetDate();
        }

        return;
    }
}
