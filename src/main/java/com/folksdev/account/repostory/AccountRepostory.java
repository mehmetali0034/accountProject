package com.folksdev.account.repostory;

import com.folksdev.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepostory extends JpaRepository<Account,String> {
}
