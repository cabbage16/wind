package com.bamdoliro.wind.web;

import com.bamdoliro.wind.domain.wind.Winds;
import com.bamdoliro.wind.domain.wind.WindsRepository;
import com.bamdoliro.wind.web.dto.WindsSaveRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WindsApiControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private WindsRepository windsRepository;

    @AfterEach
    public void tearDown() {
        windsRepository.deleteAll();
    }

    @Test
    @DisplayName("바람 등록 테스트")
    public void winds_register() {
        //given
        String content = "content";
        WindsSaveRequestDto requestDto = WindsSaveRequestDto.builder()
                .content(content)
                .build();
        String url = "http://localhost:" + port + "/api/create";

        //when
        ResponseEntity<Long> responseEntity = restTemplate
                .postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode())
                .isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody())
                .isGreaterThan(0L);

        List<Winds> all = windsRepository.findAll();
        assertThat(all.get(0).getContent()).isEqualTo(content);
    }
}