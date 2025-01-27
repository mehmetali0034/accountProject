package com.folksdev.account.dto.converter;

import com.folksdev.account.dto.AccountCustomerDto;
import com.folksdev.account.dto.CustomerDto;
import com.folksdev.account.model.Customer;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerDtoConverter {


    private final CustomerAccountDtoConverter customerAccountDtoConverter;

    public CustomerDtoConverter(CustomerAccountDtoConverter customerAccountDtoConverter) {
        this.customerAccountDtoConverter = customerAccountDtoConverter;
    }

    public AccountCustomerDto convertToAccountCustomer(Customer from) {
        if (from == null) {
            return new AccountCustomerDto("", "", "");
        }
        return new AccountCustomerDto(from.getId(), from.getName(), from.getSurname());

    }
        public CustomerDto convert(Customer from){
            return new CustomerDto(from.getId(), from.getName(), from.getSurname(),from.getAccounts()
                    .stream()
                    .map(customerAccountDtoConverter::convert)
                    .collect(Collectors.toSet()));
        }
}
