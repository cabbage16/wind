package com.bamdoliro.wind.domain.wind;

import com.bamdoliro.wind.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@Entity
public class Winds extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Length(max = 30)
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Builder
    public Winds(String content) {
        this.content = content;
    }
}