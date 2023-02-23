package company.spring.appManaging.repo;

import company.spring.appManaging.entities.AccountEntity;
import company.spring.appManaging.proj.AccountName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    @Query("select username from AccountEntity")
    List<AccountName> getAll();
}
