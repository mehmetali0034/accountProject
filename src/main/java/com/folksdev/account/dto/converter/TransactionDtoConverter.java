package com.folksdev.account.dto.converter;

import com.folksdev.account.dto.TransactionDto;
import com.folksdev.account.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoConverter {
    //Bu metod benim transaction sınıfımı, entity'mi transactionDto ' ya dönüştürmemi sağladı.
    public TransactionDto convert(Transaction from){
        return new TransactionDto(from.getId(),from.getTransactionType(),from.getAmount(),from.getTransactionDate());
    }
}
