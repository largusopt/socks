package org.example.dto;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static org.example.exception.message.SocksExceptionMessage.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SocksDto {
    @NotBlank(message = COLOR_IS_INVALID)
    private String color;

    @Min(value = 1, message = COTTON_PART_MIN)
    @Max(value = 100, message = COTTON_PART_MAX)
    @NotNull(message = COTTON_PART_IS_INVALID)
    private Integer cottonPart;

    @Min(value = 1,message = QUANTITY_MIN)
    @NotNull(message = QUANTITY_IS_INVALID)
    private Long quantity;
}
