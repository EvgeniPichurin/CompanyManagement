package company.spring.appManaging.controller;

import company.spring.appManaging.model.Account;
import company.spring.appManaging.proj.AccountName;
import company.spring.appManaging.service.AccountingService;
import jakarta.annotation.*;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("accounts")
public class AccountingController {

    Logger LOG = LoggerFactory.getLogger(AccountingController.class);

    @Value("${app.message.wrong.operation:Wrong operation}")
    String wrongOperationMessage;
    @Value("${file.path.name.accounts:accountData}")
    String filePath;
    AccountingService accountingService;

    public AccountingController(AccountingService accountingService) {
        this.accountingService = accountingService;
    }

    @PostMapping
    String addUser(@RequestBody @Valid Account account) {
        return null;
    }

    @PutMapping
    String updateUser(@RequestBody @Valid Account account) {
        return null;
    }

    @DeleteMapping("/{username}")
    String deleteUser(@PathVariable("username") String username) {
        return null;
    }

    @GetMapping("/{username}")
    boolean userExists(@PathVariable("username") String username) {
        return false;
    }

    @GetMapping("/all")
    List<AccountName> allUsers() {
        return accountingService.getAll();
    }

    @PostConstruct
    void restoreAccounts() {

    }

    @PreDestroy
    void saveAccounts() {
    }
}
