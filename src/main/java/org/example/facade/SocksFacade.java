package org.example.facade;

import lombok.RequiredArgsConstructor;
import org.example.dto.GetSocksDto;
import org.example.dto.SocksDto;
import org.example.model.Socks;
import org.example.model.Warehouse;
import org.example.service.SocksService;
import org.example.service.WarehouseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class SocksFacade {
    private final WarehouseService warehouseService;
    private final SocksService socksService;
     public SocksDto income (SocksDto incomeSocksDto){
         SocksDto socksDto;
         if (socksService.socksExists(incomeSocksDto.getColor(), incomeSocksDto.getCottonPart())) {
             Warehouse warehouse = warehouseService.incomeSocks(incomeSocksDto.getQuantity(), socksService.findByColorAndCottonPart(incomeSocksDto.getColor(), incomeSocksDto.getCottonPart()));
             socksDto = new SocksDto(incomeSocksDto.getColor(), incomeSocksDto.getCottonPart(), warehouse.getQuantity());
         } else {
             Socks socks = socksService.addSocks(incomeSocksDto.getColor(), incomeSocksDto.getCottonPart());
             warehouseService.incomeSocks(incomeSocksDto.getQuantity(), socks);
             socksDto = new SocksDto(incomeSocksDto.getColor(), incomeSocksDto.getCottonPart(), incomeSocksDto.getQuantity());
         }
         return socksDto;
     }
    public SocksDto outcome(SocksDto outcomeSocksDto) {
        Socks socks = socksService.findByColorAndCottonPart(outcomeSocksDto.getColor(), outcomeSocksDto.getCottonPart());
        Warehouse wareHouse = warehouseService.outcomeSocks(outcomeSocksDto.getQuantity(), socks);
        return new SocksDto(outcomeSocksDto.getColor(), outcomeSocksDto.getCottonPart(), wareHouse.getQuantity());
    }
    public List<SocksDto> getSocksByColorAndCottonPartAndOperation(GetSocksDto getSocksDto) {
        List<Socks> socks = socksService.getSocksByColorAndCottonPartAndOperation(getSocksDto.getColor(), getSocksDto.getCottonPart(), getSocksDto.getOperation());
        List<Long> ids = socks.stream()
                .map(sock -> sock.getId())
                .toList();
        Map<Long, Warehouse> warehouses = warehouseService.getAllBySocksIds(ids);
        return socks.stream()
                .map(sock -> new SocksDto(getSocksDto.getColor(), sock.getCottonPart(), warehouses.get(sock.getId()).getQuantity()))
                .toList();
    }

}
