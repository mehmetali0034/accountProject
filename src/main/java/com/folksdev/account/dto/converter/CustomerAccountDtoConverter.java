package com.folksdev.account.dto.converter;

import com.folksdev.account.dto.AccountDto;
import com.folksdev.account.dto.CustomerAccountDto;
import com.folksdev.account.model.Account;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerAccountDtoConverter {
    //Bu sınıf, bir müşterinin bir hesabını DTO formatına dönüştürmek için kullanılır
    //müşteriye ait hesaplar, CustomerAccountDtoConverter aracılığıyla AccountCustomerDto'lara dönüştürülür ve bir küme olarak toplanır.

    private final TransactionDtoConverter transactionDtoConverter;

    public CustomerAccountDtoConverter(TransactionDtoConverter transactionDtoConverter) {
        this.transactionDtoConverter = transactionDtoConverter;
    }

    public CustomerAccountDto convert(Account from){
        return new CustomerAccountDto(from.getId(),from.getBalance(),from.getTransactions()
                .stream()
                .map(transactionDtoConverter::convert)//Getirdiği transactionları transacitonDto ya çevirmesini istedim.
                .collect(Collectors.toSet()),
        from.getCreationDate());
    }
}
