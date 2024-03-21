package com.folksdev.account.dto.converter;

import com.folksdev.account.dto.AccountDto;
import com.folksdev.account.model.Account;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class AccountDtoConverter {
    /*
    Bu sınıf, bir Account entity'sini bir AccountDto DTO'suna dönüştürmek için kullanılır. Yani, veri tabanından alınan
    Account nesnelerini, genellikle kullanıcı arayüzü veya dış dünya ile iletişimde kullanılan AccountDto nesnelerine
    dönüştürmek için kullanılır.
     */
    private final CustomerDtoConverter customerDtoConverter;
    private final TransactionDtoConverter transactionDtoConverter;

    public AccountDtoConverter(CustomerDtoConverter customerDtoConverter, TransactionDtoConverter transactionDtoConverter) {
        this.customerDtoConverter = customerDtoConverter;
        this.transactionDtoConverter = transactionDtoConverter;
    }

    public AccountDto convert(Account from){
        return new AccountDto(from.getId(),from.getBalance(),from.getCreationDate(),
              this.customerDtoConverter.convertToAccountCustomer(from.getCustomer()) ,
                Objects.requireNonNull(from.getTransactions())
                        .stream()
                        .map(transactionDtoConverter::convert)
                        .collect(Collectors.toSet()));
    }
}

