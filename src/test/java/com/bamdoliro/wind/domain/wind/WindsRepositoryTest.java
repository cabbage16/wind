package com.bamdoliro.wind.domain.wind;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class WindsRepositoryTest {
    @Autowired
    WindsRepository windsRepository;

    @AfterEach
    public void cleanUp() {
        windsRepository.deleteAll();
    }

    @Test
    @DisplayName("바람 저장 테스트")
    public void winds_saveTest() {
        //given
        String content = "바람 테스트";

        windsRepository.save(Winds.builder()
                .content(content)
                .build());

        //when
        List<Winds> windsList = windsRepository.findAll();

        //then
        Winds winds = windsList.get(0);
        assertThat(winds.getContent()).isEqualTo(content);
    }

    @Test
    @DisplayName("바람의 저장시간이 현재 시간보다 미래이다.")
    public void winds_baseTimeTest() {
        //given
        LocalDateTime now = LocalDateTime.now();
        String content = "바람 저장시간 테스트";

        windsRepository.save(Winds.builder()
                .content(content)
                .build());

        //when
        List<Winds> windsList = windsRepository.findAll();

        //then
        Winds winds = windsList.get(0);

        System.out.println("> createDate = " + winds.getCreatedDate());

        assertThat(winds.getCreatedDate()).isAfter(now);
    }
}