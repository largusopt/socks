package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.exception.ObjectNotFoundException;
import org.example.exception.SocksNotEnoughException;
import org.example.model.Socks;
import org.example.model.Warehouse;
import org.example.repository.WarehouseRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.example.exception.message.SocksExceptionMessage.SOCKS_NOT_ENOUGHT;
import static org.example.exception.message.SocksExceptionMessage.SOCKS_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Slf4j
public class WareHouseServiceImpl implements WarehouseService {
    private final WarehouseRepository warehouseRepository;

    @Override
    public Warehouse incomeSocks(Long quantity, Socks socks) {
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findBySocksId(socks.getId());
        if (optionalWarehouse.isEmpty()) {
            Warehouse warehouse = Warehouse.builder()
                    .quantity(quantity)
                    .socksId(socks.getId())
                    .build();
            warehouseRepository.save(warehouse);
            return warehouse;
        } else {
            Warehouse warehouse = optionalWarehouse.get();
            long oldQuantity = warehouse.getQuantity();
            warehouse.setQuantity(oldQuantity + quantity);
            warehouseRepository.save(warehouse);
            return warehouse;
        }
    }

    @Override
    public Warehouse outcomeSocks(Long quantity, Socks socks) {
        Warehouse warehouse = warehouseRepository.findBySocksId(socks.getId())
                .orElseThrow(() -> new ObjectNotFoundException(SOCKS_NOT_FOUND));
        long oldQuantity = warehouse.getQuantity();
        if (quantity > oldQuantity) {
            log.error(SOCKS_NOT_ENOUGHT);
            throw new SocksNotEnoughException(SOCKS_NOT_ENOUGHT);
        }
        warehouse.setQuantity(oldQuantity - quantity);
        warehouseRepository.save(warehouse);
        return warehouse;
    }

    @Override
    public Map<Long, Warehouse> getAllBySocksIds(List<Long> socksId) {
        Map<Long, Warehouse> socksIdAndWarehouses = new HashMap<>();
        List<Warehouse> warehouses = warehouseRepository.findBySocksIdIn(socksId);
        for (Warehouse warehouse : warehouses) {
            socksIdAndWarehouses.put(warehouse.getSocksId(), warehouse);
        }
        return socksIdAndWarehouses;
    }
}
