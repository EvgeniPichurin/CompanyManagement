package company.spring.appManaging.model;

import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

public class Account implements Serializable {

    public long id;
    @Email @NotNull
    public String username;
    @Size(min = 6) @NotNull
    public String password;
    @NotNull
    public String role;

    public Account(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Account() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(username, account.username) && Objects.equals(password, account.password) && Objects.equals(role, account.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, role);
    }
}
