package org.example.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static org.example.exception.message.SocksExceptionMessage.*;
import static org.example.exception.message.SocksExceptionMessage.COTTON_PART_IS_INVALID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetSocksDto {
    @NotBlank(message = COLOR_IS_INVALID)
    private String color;

    @Min(value = 1, message = COTTON_PART_MIN)
    @Max(value = 100, message = COTTON_PART_MAX)
    @NotNull(message = COTTON_PART_IS_INVALID)
    private Integer cottonPart;

    @NotBlank(message = OPERATION_NOT_FOUND)
    private String operation;
}
