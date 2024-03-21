package com.folksdev.account.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountRequest {
    @NotBlank(message = "This field can not be empty !")
    private String customerId;

    @Min(value = 0, message = "Initial Credit value must not be negative value")
    private BigDecimal initialCredit;
}
