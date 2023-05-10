package com.example.demo.quiz.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
public class Quiz {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String category;

    @NotNull
    private String title;

    @NotNull
    private String content;

    @NotNull
    private String quiz;

    @NotNull
    private int answer;

    @NotNull
    private String seletion1;

    @NotNull
    private String seletion2;

    @NotNull
    private String seletion3;

    @NotNull
    private String seletion4;
    @Nullable
    private LocalDate date;

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void resetDate(){
        this.date = null;
    }
}
