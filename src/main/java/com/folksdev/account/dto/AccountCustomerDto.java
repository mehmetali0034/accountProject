package com.folksdev.account.dto;

import lombok.*;
import org.springframework.web.service.annotation.GetExchange;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class AccountCustomerDto {
    /*
       Bu da hesaabın müşteirisini bigisini dto şeklinde tutmak için yazılmıştır.
     */
    private String id;
    private String name;
    private String surname;
}
