package ru.neotoria.gempl.microservices.account_service.domain.repository;

import org.springframework.stereotype.Repository;
import ru.neotoria.gempl.microservices.common_service.util.ExtendedRepository;
import ru.neotoria.gempl.microservices.account_service.domain.entity.Account;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountRepository extends ExtendedRepository<Account, UUID> {

    boolean existsByEmail(String email);

    Optional<Account> findByEmail(String email);

    List<Account> findAllByRoleId(Long roleId);
}
