package company.spring;

import company.spring.appManaging.model.Account;
import company.spring.appManaging.service.AccountingService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@Component
public class RandomDbCreation {
    static Logger LOG = LoggerFactory.getLogger(RandomDbCreation.class);
    @Value("${app.accounts.amount: 10}")
    int nAccounts;
    @Value("${spring.jpa.hibernate.ddl-auto: update}")
    String ddlAutoProp;
    @Autowired
    AccountingService accountingService;
    String names[] = { "Abraham", "Sarah", "Itshak", "Rahel", "Asaf", "Yacob", "Rivka", "Yosef", "Benyanim", "Dan",
            "Ruben", "Moshe", "Aron", "Yehashua", "David", "Salomon", "Nefertity", "Naftaly", "Natan", "Asher" };
    String roles[] = { "ACCOUNT MANAGER", "ACCOUNTANT", "USER" };

    String passwords[] = { "123", "1234", "12345" };

    @PostConstruct
    void createDB() {
        if (ddlAutoProp.equals("create")) {
            addAccounts();
            LOG.info("created {} random marks in DB", nAccounts);
        } else {
            LOG.warn("DB no created - assumed that it exists");
        }
    }

    private void addAccounts() {
        IntStream.range(0, nAccounts).forEach(i -> accountingService.add(
                new Account(
                        names[getRandomNumber(0, names.length)],
                        passwords[getRandomNumber(0, passwords.length)],
                        roles[getRandomNumber(0, roles.length)]
                )));
    }

    private int getRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

}
