package com.folksdev.account.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")//Bu şekilde benzersiz Id ler üreitr. UUID olunca rasgele sayı üretir .
    private String id;

    private BigDecimal balance; //Büyük e hassas bir sayı olduğu için bigDecial tercih ettik.BigDecimal veri tipi, yüksek hassasiyet ve tam sayımla ondalık sayıları temsil etmek için kullanılır.
    private LocalDateTime creationDate; //LocalDateTime, Java'da tarih ve saat bilgisini temsil etmek için kullanılan bir sınıftır.

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)//FetchType içerisnde Lazy ve EAGER var.Lazy sadece ihtiyaç olan kolonun geitrir.EAGER ise diğer tablodaki tüm kolonlarıda getirir.
    @JoinColumn(name = "customer_id", nullable = false)//Yani account tablomda customer_id adında bir kolon açacaktır.Bu kolon üzerinde customer tablosu ile birleştirecek.
    //nullable = false, bu sütunun boş olamayacağını belirtir.
    private Customer customer;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)//Mapped by içindeki değer karşı tarfta hangi alanın bu ilişkiyi yönettiğini belirtir.
    //cascade = CascadeType.ALL aacountu kaydedereken transactionnuda kaydet her şeyiyle anlamına gelir
    private Set<Transaction> transactions = new HashSet<>();

    public Account(Customer customer, BigDecimal balance, LocalDateTime creationDate) {
        this.balance = balance;
        this.creationDate = creationDate;
        this.customer = customer;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (id != null ? !id.equals(account.id) : account.id != null) return false;
        if (balance != null ? !balance.equals(account.balance) : account.balance != null) return false;
        if (!creationDate.equals(account.creationDate)) return false;
        if (customer != null ? !customer.equals(account.customer) : account.customer != null) return false;
        return transactions != null ? transactions.equals(account.transactions) : account.transactions == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + creationDate.hashCode();
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        //Customer One olduğu için silmedim ama transaction many olduğu için sildim.
        return result;
    }
}