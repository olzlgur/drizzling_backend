package com.example.demo.topic.repository;

import com.example.demo.quiz.domain.Quiz;
import com.example.demo.topic.domain.Topic;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TopicRepository {

    private final EntityManager em;

    public Topic getTopic() {
        String sql = "select * from topic where date is null order by rand() limit 1";
        Query query = em.createNativeQuery(sql, Topic.class);

        Topic topic = (Topic) query.getSingleResult();

        return topic;
    }

    public Optional<Topic> findByDate(LocalDate localDate) {
        String sql = "select * from topic where date = :date";
        Query query = em.createNativeQuery(sql, Topic.class)
                .setParameter("date", localDate);

        return query.getResultList().stream().findAny();
    }

    public List<Topic> findAll(){
        String sql = "select * from topic";
        Query query = em.createNativeQuery(sql, Topic.class);

        return query.getResultList();

    }

}
