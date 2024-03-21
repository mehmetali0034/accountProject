package com.folksdev.account.service;

import com.folksdev.account.dto.AccountDto;
import com.folksdev.account.dto.CreateAccountRequest;
import com.folksdev.account.dto.converter.AccountDtoConverter;
import com.folksdev.account.model.Account;
import com.folksdev.account.model.Customer;
import com.folksdev.account.model.Transaction;
import com.folksdev.account.repostory.AccountRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/*
Java'nın yerel değişkenler için varsayılan bir uygulaması olan "effectively final" kuralını da izlersiniz. Bu kurala göre,
bir yerel değişken, değeri atanıp daha sonra değiştirilmediği sürece, o değişkeni final olarak işaretleyebilirsiniz. Bu,
kodun daha temiz ve daha okunabilir olmasını sağlar ve yanlışlıkla değiştirilmesini önler.
 */
@Service
public class AccountService {
    private final AccountRepostory accountRepostory ;//Fianl yapmam bunu bir default değeri olması gerektiği anlamına gelir.
    // Bu yüzden final yapınca ya direk bir değere eşitlemeliyim ya da constroctor yazmalıyımz
    private final CustomerService customerService;
    private final AccountDtoConverter accountDtoConverter;
    public AccountService(AccountRepostory accountRepostory,CustomerService customerService,AccountDtoConverter accountDtoConverter){
        this.accountRepostory = accountRepostory;
        this.customerService=customerService;
        this.accountDtoConverter = accountDtoConverter;
    }
    public AccountDto createAccount(CreateAccountRequest createAccountRequest){
        Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId());
        Account account = new Account(customer,
                createAccountRequest.getInitialCredit(),
                LocalDateTime.now()
        );
        if(createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO)>0){
            //Yani getİnitialKredit ile BigDecimal0'ı kıyasladı bunun sonucu eğer büyükse 1, eşitse 0 ,Küçükse -1 dönecektir.
            //Eğer başlangıçKredisi 0 dan büyükse bir işlem göndermemizi istiyor.
            Transaction transaction = new Transaction(createAccountRequest.getInitialCredit(),
                    LocalDateTime.now(),
                    account
            );//Başlangıç Kredisinin 0 olmadğıı durumda accounta ekleyeceğim işlemi oluşturdum.
            account.getTransactions().add(transaction);
        }
        return accountDtoConverter.convert(accountRepostory.save(account));
    }
    public List<AccountDto> getAllAccounts(){
        List<Account> accounts = this.accountRepostory.findAll();
        List<AccountDto> accountDtos = new ArrayList<>();
        for(Account account : accounts){
            accountDtos.add(accountDtoConverter.convert(account));
        }
        return accountDtos;
    }
}

