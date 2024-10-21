package org.example.repository;

import org.example.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
    Optional<Warehouse> findBySocksId(Long socksId);

    List<Warehouse> findBySocksIdIn(List<Long> socksId);
}
