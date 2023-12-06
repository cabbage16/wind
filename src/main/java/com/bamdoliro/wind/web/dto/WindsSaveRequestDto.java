package com.bamdoliro.wind.web.dto;

import com.bamdoliro.wind.domain.wind.Winds;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WindsSaveRequestDto {
    private String content;

    @Builder
    public WindsSaveRequestDto(String content) {
        this.content = content;
    }

    public Winds toEntity() {
        return Winds.builder()
                .content(content)
                .build();
    }
}
