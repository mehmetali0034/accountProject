package com.folksdev.account;

import com.folksdev.account.model.Customer;
import com.folksdev.account.repostory.CustomerRepostory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLOutput;
import java.util.HashSet;

@SpringBootApplication
public class AccountApplication implements CommandLineRunner{
	private  final CustomerRepostory customerRepostory ;

	public AccountApplication(CustomerRepostory customerRepostory) {
		this.customerRepostory = customerRepostory;
	}
    public static void main(String[] args) {

		SpringApplication.run(AccountApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Customer customer =  customerRepostory.save(new Customer("","Ali","Kolcuk",new HashSet<>()));
		System.out.println(customer.getId());
	}
}
