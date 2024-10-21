package org.example.service;

import org.example.model.Socks;
import org.example.model.Warehouse;

import java.util.List;
import java.util.Map;

public interface WarehouseService {
    Warehouse incomeSocks(Long quantity, Socks socks);

    Warehouse outcomeSocks(Long quantity, Socks socks);

    Map<Long, Warehouse> getAllBySocksIds(List<Long> socksId);
}
