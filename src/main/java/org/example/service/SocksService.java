package org.example.service;

import org.example.model.Socks;

import java.util.List;

public interface SocksService {
    Socks addSocks(String color, Integer cottonPart);

    Socks findByColorAndCottonPart(String color, Integer cottonPart);

    List<Socks> getSocksByColorAndCottonPartAndOperation(String color, Integer cottonPart, String operation);

    boolean socksExists(String color, Integer cottonPart);
}

