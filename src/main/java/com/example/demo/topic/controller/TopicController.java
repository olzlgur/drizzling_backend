package com.example.demo.topic.controller;

import com.example.demo.global.response.CommonResponse;
import com.example.demo.topic.dto.TopicResponseDto;
import com.example.demo.topic.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topic")
@RequiredArgsConstructor
public class TopicController {

    private final TopicService topicService;

    @GetMapping("/get")
    public TopicResponseDto getTopic() {
        return topicService.getTopic();
    }

    @DeleteMapping("/resetDate")
    public void resetDate() {
        topicService.deleteAllDate();
        return;
    }

}
