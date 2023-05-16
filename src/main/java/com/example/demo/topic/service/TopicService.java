package com.example.demo.topic.service;

import com.example.demo.quiz.domain.Quiz;
import com.example.demo.topic.domain.Topic;
import com.example.demo.topic.dto.TopicResponseDto;
import com.example.demo.topic.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TopicService {

    private final TopicRepository topicRepository;

    @Transactional
    public TopicResponseDto getTopic() {
        LocalDate time = LocalDate.now();
        Optional<Topic> optionalTopic = topicRepository.findByDate(time);
        TopicResponseDto topicResponseDto = new TopicResponseDto();
        if (optionalTopic.isPresent()) {
            topicResponseDto.setTopic(optionalTopic.get().getTopic());
            return topicResponseDto;
        }

        Topic topic = topicRepository.getTopic();
        topic.setDate(time);

        topicResponseDto.setTopic(topic.getTopic());

        return topicResponseDto;
    }

    @Transactional
    public void deleteAllDate() {
        List<Topic> topicList = topicRepository.findAll();

        for (Topic topic : topicList){
            topic.resetDate();
        }

        return;
    }
}
