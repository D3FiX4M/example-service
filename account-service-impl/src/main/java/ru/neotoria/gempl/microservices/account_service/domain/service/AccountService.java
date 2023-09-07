package ru.neotoria.gempl.microservices.account_service.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.neotoria.gempl.microservices.common_service.exception.GlobalError;
import ru.neotoria.gempl.microservices.common_service.exception.GlobalException;
import ru.neotoria.gempl.microservices.common_service.util.SHA1Generator;
import ru.neotoria.gempl.microservices.account_service.domain.entity.Account;
import ru.neotoria.gempl.microservices.account_service.domain.repository.AccountRepository;
import ru.neotoria.gempl.microservices.account_service.payload.constant.EAccountStatus;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository repository;

    public Account create(
            String email,
            String password,
            Long roleId,
            Long languageId,
            Long timezoneId
    ) {
        if (repository.existsByEmail(email)) {
            throw GlobalException.of(GlobalError.ALREADY_EXIST_ERROR);
        }

        return repository.save(
                new Account(
                        UUID.randomUUID(),
                        email,
                        SHA1Generator.generateSHA1(password),
                        EAccountStatus.NEW,
                        roleId,
                        languageId,
                        timezoneId,
                        LocalDateTime.now()
                )
        );
    }

    public List<Account> getByIds(Collection<UUID> ids) {
        return repository.getEntityByIds(ids);
    }

    public Account getById(UUID id) {
        return repository.getEntityById(id);
    }

    public Account getByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> GlobalException.of(GlobalError.NOT_FOUND_ERROR));
    }

    public void changePassword(UUID userId, String password) {
        Account account = getById(userId);
        account.setPassword(SHA1Generator.generateSHA1(password));
        repository.save(account);
    }

    public void changeStatus(UUID userId, EAccountStatus status) {
        Account account = getById(userId);
        account.setStatus(status);
        repository.save(account);
    }

    public void changeLanguage(UUID userId, Long languageId) {
        Account account = getById(userId);
        account.setLanguageId(languageId);
        repository.save(account);
    }

    public void changeRole(UUID userId, Long roleId) {
        Account account = getById(userId);
        account.setRoleId(roleId);
        repository.save(account);
    }

    public void changeTimezone(UUID userId, Long timezoneId) {
        Account account = getById(userId);
        account.setTimezoneId(timezoneId);
        repository.save(account);
    }

    public void migrateUserRoles(Long prevRoleId, Long nextRoleId) {
        List<Account> usersWithPrevRole = repository.findAllByRoleId(prevRoleId);

        usersWithPrevRole
                .forEach(account -> account.setRoleId(nextRoleId));

        repository.saveAll(usersWithPrevRole);
    }
}
