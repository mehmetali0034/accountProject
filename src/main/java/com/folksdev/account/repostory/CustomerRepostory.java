package com.folksdev.account.repostory;

import com.folksdev.account.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepostory extends JpaRepository<Customer,String> {
}
