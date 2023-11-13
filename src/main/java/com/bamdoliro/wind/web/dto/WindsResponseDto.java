package com.bamdoliro.wind.web.dto;

import com.bamdoliro.wind.domain.wind.Winds;
import lombok.Getter;

@Getter
public class WindsResponseDto {
    private Long id;
    private String content;

    public WindsResponseDto(Winds winds) {
        this.id = winds.getId();
        this.content = winds.getContent();
    }
}
