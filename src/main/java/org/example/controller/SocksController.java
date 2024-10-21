package org.example.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.GetSocksDto;
import org.example.dto.SocksDto;
import org.example.facade.SocksFacade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/socks")
@RequiredArgsConstructor
@Slf4j
public class SocksController {
    private final SocksFacade socksFacade;

    @PostMapping("/income")
    @ResponseStatus(HttpStatus.CREATED)
    public SocksDto income(@Valid @RequestBody SocksDto incomeSocks) {
        log.info("Выполнение запроса на добавление носков: {}",incomeSocks);
        SocksDto socksDto= socksFacade.income(incomeSocks);
        log.info("Запрос на добавление носков выполнен: {}",socksDto);
        return socksDto;
    }

    @DeleteMapping("/outcome")
    public SocksDto outcome(@Valid @RequestBody SocksDto outcomeSocks) {
        log.info("Выполнение запроса на удаление носков: {}",outcomeSocks);
        SocksDto socksDto =socksFacade.outcome(outcomeSocks);
        log.info("Запрос на удаление носков выполнен: {}",socksDto);
        return socksDto;
    }

    @GetMapping
    public List<SocksDto> getSocksByColorAndCottonPartAndOperation(@Valid @RequestBody GetSocksDto getSocksDto) {
        log.info("Выполнение запроса на поиск носков: {}",getSocksDto);
        List<SocksDto> socks = socksFacade.getSocksByColorAndCottonPartAndOperation(getSocksDto);
        log.info("Запрос на поиск носков выполнен");
        return socks;
    }
}
