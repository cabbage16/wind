package com.bamdoliro.wind.domain;

import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

public class BaseTimeEntity {
    @CreatedDate
    private LocalDateTime createdDate;
}
