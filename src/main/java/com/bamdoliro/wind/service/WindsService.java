package com.bamdoliro.wind.service;

import com.bamdoliro.wind.domain.wind.Winds;
import com.bamdoliro.wind.domain.wind.WindsRepository;
import com.bamdoliro.wind.web.dto.WindsResponseDto;
import com.bamdoliro.wind.web.dto.WindsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class WindsService {
    private final WindsRepository windsRepository;

    @Transactional
    public Long save(WindsSaveRequestDto windsSaveRequestDto) {
        return windsRepository.save(windsSaveRequestDto.toEntity()).getId();
    }

    public List<WindsResponseDto> findAll(){
        List<Winds> windsList = windsRepository.findAll();
        return windsList.stream()
                .map(WindsResponseDto::new)
                .collect(Collectors.toList());
    }
}