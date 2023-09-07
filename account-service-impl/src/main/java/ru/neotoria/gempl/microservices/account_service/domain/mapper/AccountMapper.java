package ru.neotoria.gempl.microservices.account_service.domain.mapper;

import org.springframework.stereotype.Component;
import ru.neotoria.gempl.microservices.account_service.domain.entity.Account;
import ru.neotoria.gempl.microservices.account_service.payload.response.AccountMultipleResponse;
import ru.neotoria.gempl.microservices.account_service.payload.response.AccountResponse;

import java.util.Collection;

@Component
public class AccountMapper {

    public AccountResponse toUserResponse(Account account) {
        return new AccountResponse(
                account.getId(),
                account.getEmail(),
                account.getPassword(),
                account.getStatus(),
                account.getRoleId(),
                account.getLanguageId(),
                account.getTimezoneId(),
                account.getCreatedAt()
        );
    }

    public AccountMultipleResponse toMultipleUserResponse(Collection<Account> accounts) {
        return new AccountMultipleResponse(
                accounts
                        .stream()
                        .map(this::toUserResponse)
                        .toList()
        );

    }
}
