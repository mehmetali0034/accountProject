package com.folksdev.account.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAccountDto {
    /*
    AccountDto: Bu sınıf, bir hesabın DTO (Data Transfer Object) temsilini tanımlar. Hesabın genel bilgilerini içerirken,
    müşteriye ait detayları içermez. Bu sınıf, hesap bilgilerini ve bu hesapla ilişkilendirilmiş işlemleri taşımak için
    kullanılır. Genellikle hesap bilgilerini ve işlem geçmişini görüntülemek veya değiştirmek için kullanılır.

CustomerAccountDto: Bu sınıf ise bir müşterinin hesabının DTO temsilini tanımlar. Bu, müşteri ve hesap bilgilerini bir
 arada tutar. Müşterinin hesabıyla ilişkili işlemleri içerebilir. Genellikle bir müşterinin tüm hesaplarını ve bu hesapların
  detaylarını görüntülemek veya değiştirmek için kullanılır.
     */
    //Customer içerisinde account bilgileri
    /*
    Bu sınıf genellikle müşteri (customer) varlığını temsil ederken, bu müşteriye bağlı olan hesapları (account) içerir.
    Yani, müşteriye ait hesapların listesi veya bilgileri içerebilir. Örneğin, bir müşterinin adı, soyadı ve
    hesaplarının listesi gibi bilgileri içerebilir.
     */
    //Bu sınıf, hesaba ait bilgileri ve bu hesapla ilişkilendirilmiş işlemleri taşımak için kullanılır.
    private String id;
    private BigDecimal balance = BigDecimal.ZERO;
    private Set<TransactionDto> transactions;
    private LocalDateTime creationDate;

}
