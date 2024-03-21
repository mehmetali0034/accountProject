package com.folksdev.account.dto;

import com.folksdev.account.model.Transaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {
    private String id;
    private Transaction.TransactionType transactionType = Transaction.TransactionType.INITIAL;
    private BigDecimal amount;
    private LocalDateTime transactionDate;
}
