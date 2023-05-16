package com.example.demo.topic.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
public class Topic {

    @GeneratedValue
    @Id
    private Long id;

    @NotNull
    private String topic;

    @Nullable
    private LocalDate date;

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void resetDate() {
        this.date = null;
    }
}
