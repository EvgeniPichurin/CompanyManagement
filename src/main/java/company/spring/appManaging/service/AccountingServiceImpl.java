package company.spring.appManaging.service;

import company.spring.appManaging.entities.AccountEntity;
import company.spring.appManaging.model.Account;
import company.spring.appManaging.proj.AccountName;
import company.spring.appManaging.repo.AccountRepository;
import jakarta.persistence.EntityManager;
import org.slf4j.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AccountingServiceImpl implements AccountingService {
    Logger LOG = LoggerFactory.getLogger(AccountingServiceImpl.class);

    AccountRepository accountRepository;
    EntityManager em;
    UserDetailsManager manager;
    PasswordEncoder encoder;

    public AccountingServiceImpl(AccountRepository accountRepository,
                                 EntityManager em,
                                 UserDetailsManager manager,
                                 PasswordEncoder encoder) {
        this.accountRepository = accountRepository;
        this.em = em;
        this.manager = manager;
        this.encoder = encoder;
    }

    @Override
    @Transactional
    public void add(Account account) {
        if (accountRepository.existsById(account.id)) {
            throw new IllegalStateException(String.format("Account with id %d already exist",
                    account.id));
        }
        String encodedPass = encoder.encode(account.password);
        manager.createUser(User.withUsername(account.username)
                .password(encodedPass)
                .roles(account.role).build());
        accountRepository.save(new AccountEntity(account.username, encodedPass, account.role));
    }

    @Override
    public List<AccountName> getAll() {
        return accountRepository.getAll();
    }
}