package com.bamdoliro.wind.web;

import com.bamdoliro.wind.service.WindsService;
import com.bamdoliro.wind.web.dto.WindsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class WindsApiController {
    private final WindsService windsService;

    @PostMapping("/api/create")
    public Long save(@RequestBody WindsSaveRequestDto windsSaveRequestDto) {
        return windsService.save(windsSaveRequestDto);
    }
}
