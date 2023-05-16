package com.example.demo.topic.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TopicResponseDto {

    @NotNull
    private String topic;
}
