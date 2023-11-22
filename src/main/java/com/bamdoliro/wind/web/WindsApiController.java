package com.bamdoliro.wind.web;

import com.bamdoliro.wind.service.WindsService;
import com.bamdoliro.wind.web.dto.WindsResponseDto;
import com.bamdoliro.wind.web.dto.WindsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class WindsApiController {
    private final WindsService windsService;

    @PostMapping("/create")
    public ResponseEntity<String> save(@RequestBody WindsSaveRequestDto requestDto) {
        if(requestDto.getContent().isBlank()) {
            return ResponseEntity.badRequest().body("바람은 비어있을 수 없습니다.");
        }
        else if (requestDto.getContent().length() > 30) {
            return ResponseEntity.badRequest().body("바람은 30글자를 초과할 수 없습니다.");
        }
        else {
            windsService.save(requestDto);
            return ResponseEntity.ok().body("바람이 정상적으로 등록되었습니다.");
        }
    }

    @GetMapping("/view")
    public List<WindsResponseDto> findAll() {
        return windsService.findAll();
    }
}