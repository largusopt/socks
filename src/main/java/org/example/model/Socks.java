package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static org.example.exception.message.SocksExceptionMessage.COLOR_IS_INVALID;
import static org.example.exception.message.SocksExceptionMessage.COTTON_PART_IS_INVALID;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "socks")
@Builder
public class Socks {
    @Id //обозначение ПК
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = COLOR_IS_INVALID)
    private String color;

    @NotNull(message = COTTON_PART_IS_INVALID)
    @Min(1)
    @Max(100)
    @Column(name = "cotton_part")
    private Integer cottonPart;

}
