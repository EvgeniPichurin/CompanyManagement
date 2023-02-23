package company.spring.appManaging.service;


import company.spring.appManaging.model.Account;
import company.spring.appManaging.proj.AccountName;

import java.util.List;

public interface AccountingService {
    void add(Account account);
//
//    Boolean deleteAccount(String username);
//
//    Boolean updateAccount(Account account);
//
//    Boolean isExist(String username);

    List<AccountName> getAll();
}
