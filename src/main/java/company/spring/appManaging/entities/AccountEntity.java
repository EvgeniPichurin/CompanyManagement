package company.spring.appManaging.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts_db")
public class AccountEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    long id;

    String username;

    String password;

    String role;

    public AccountEntity(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public AccountEntity() {
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}
