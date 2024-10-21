package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static org.example.exception.message.WareHouseExceptionMessage.ID_SOCKS;
import static org.example.exception.message.WareHouseExceptionMessage.QUANTITY_IS_INVALID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "warehouses")
@Builder
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = QUANTITY_IS_INVALID)
    private Long quantity;

    @NotNull(message = ID_SOCKS)
    @Column(name = "socks_id")
    private Long socksId;
}
