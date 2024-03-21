package com.folksdev.account.repostory;

import com.folksdev.account.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepostory extends JpaRepository<Transaction,String> {
}
