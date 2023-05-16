package com.example.demo.quiz.repository;

import com.example.demo.quiz.domain.Quiz;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class QuizRepository {

    private final EntityManager em;

    public Quiz getQuiz(String category) {
        String sql = "select * from quiz where date = null and category = :category order by rand() limit 1";
        Query query = em.createNativeQuery(sql, Quiz.class)
                .setParameter("category", category);
        Quiz quiz = (Quiz) query.getSingleResult();

        return quiz;
    }

    public Quiz findById(Long id) {
        String sql = "select * from quiz where id = :id";
        Query query = em.createNativeQuery(sql, Quiz.class)
                .setParameter("id", id);
        Quiz quiz = (Quiz) query.getSingleResult();

        return quiz;
    }

    public Optional<Quiz> findByDateAndCategory(LocalDate localDate, String category) {
        String sql = "select * from quiz where date = :date and category = :category";
        Query query = em.createNativeQuery(sql, Quiz.class)
                .setParameter("category", category)
                .setParameter("date", localDate);

        return query.getResultList().stream().findAny();
    }

    public List<Quiz> findAll(){
        String sql = "select * from quiz";
        Query query = em.createNativeQuery(sql, Quiz.class);

        return query.getResultList();

    }
}
