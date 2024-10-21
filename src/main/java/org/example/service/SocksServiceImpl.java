package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.exception.ObjectNotFoundException;
import org.example.exception.OperationNotFoundException;
import org.example.exception.SocksExistsException;
import org.example.model.Socks;
import org.example.repository.SocksRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.example.exception.message.SocksExceptionMessage.OPERATION_NOT_FOUND;
import static org.example.exception.message.SocksExceptionMessage.SOCKS_ALREADY_EXISTS;
import static org.example.utils.Constants.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class SocksServiceImpl implements SocksService {
    private final SocksRepository socksRepository;

    @Override
    public Socks addSocks(String color, Integer cottonPart) {
        Socks socks = Socks.builder()
                .color(color)
                .cottonPart(cottonPart)
                .build();
        if (socksRepository.existsSocksByColorAndCottonPart(color, cottonPart)) {
            log.error(SOCKS_ALREADY_EXISTS);
            throw new SocksExistsException(SOCKS_ALREADY_EXISTS);
        }
        return socksRepository.save(socks);
    }

    @Override
    public Socks findByColorAndCottonPart(String color, Integer cottonPart) {
        Optional<Socks> socks = socksRepository.findByColorAndCottonPart(color, cottonPart);
        if (socks.isEmpty()) {
            log.error("Таких носков не существует");
            throw new ObjectNotFoundException("Таких носков не существует");
        }
        return socks.get();
    }

    @Override
    public List<Socks> getSocksByColorAndCottonPartAndOperation(String color, Integer cottonPart, String operation) {
        checkOperation(operation);
        return switch (operation) {
            case MORE_THAN_OPERATION -> socksRepository.findByColorAndCottonPartGreaterThan(color, cottonPart);
            case LESS_THAN_OPERATION -> socksRepository.findByColorAndCottonPartLessThan(color, cottonPart);
            case EQUALS_OPERATION -> socksRepository.findByColorAndCottonPartEquals(color, cottonPart);
            default -> new ArrayList<>();
        };
    }

    private void checkOperation(String operation) {
        if (!MORE_THAN_OPERATION.equals(operation) && !LESS_THAN_OPERATION.equals(operation) && !EQUALS_OPERATION.equals(operation)) {
            log.error(OPERATION_NOT_FOUND);
            throw new OperationNotFoundException(OPERATION_NOT_FOUND);
        }
    }

    @Override
    public boolean socksExists(String color, Integer cottonPart) {
        return socksRepository.existsSocksByColorAndCottonPart(color, cottonPart);
    }

}
