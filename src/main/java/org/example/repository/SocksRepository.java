package org.example.repository;

import org.example.model.Socks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SocksRepository extends JpaRepository<Socks, Long> {
    boolean existsSocksByColorAndCottonPart(String color, Integer cottonPart);

    Optional<Socks> findByColorAndCottonPart(String color, Integer cottonPart);

    List<Socks> findByColorAndCottonPartGreaterThan(String color, Integer cottonPart);

    List<Socks> findByColorAndCottonPartLessThan(String color, Integer cottonPart);

    List<Socks> findByColorAndCottonPartEquals(String color, Integer cottonPart);
}

