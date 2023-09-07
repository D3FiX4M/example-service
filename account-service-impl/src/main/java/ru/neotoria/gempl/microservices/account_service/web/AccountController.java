package ru.neotoria.gempl.microservices.account_service.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.neotoria.gempl.microservices.account_service.api.AccountApi;
import ru.neotoria.gempl.microservices.account_service.payload.request.*;
import ru.neotoria.gempl.microservices.account_service.payload.response.AccountMultipleResponse;
import ru.neotoria.gempl.microservices.account_service.payload.response.AccountResponse;
import ru.neotoria.gempl.microservices.account_service.domain.mapper.AccountMapper;
import ru.neotoria.gempl.microservices.account_service.domain.service.AccountService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AccountController implements AccountApi {

    private final AccountService service;
    private final AccountMapper mapper;

    @Override
    public AccountResponse create(CreateRequest request) {



        return mapper.toUserResponse(
                service.create(
                        request.email(),
                        request.password(),
                        request.roleId(),
                        request.languageId(),
                        request.timeZoneId()
                )
        );
    }

    @Override
    public AccountMultipleResponse getByIds(GetByIdsRequest request) {
        return mapper.toMultipleUserResponse(
                service.getByIds(
                        request.ids()
                )
        );
    }


    @Override
    public AccountResponse getById(UUID id) {
        return mapper.toUserResponse(
                service.getById(id)
        );
    }

    @Override
    public AccountResponse getByEmail(GetByEmailRequest request) {
        return mapper.toUserResponse(
                service.getByEmail(
                        request.email()
                )
        );
    }


    @Override
    public void changePassword(UUID id,
                               ChangePasswordRequest request) {
        service.changePassword(
                id,
                request.password()
        );
    }


    @Override
    public void changeStatus(UUID id,
                             ChangeStatusRequest request) {
        service.changeStatus(
                id,
                request.status()
        );
    }


    @Override
    public void changeLanguage(UUID id,
                               ChangeLanguageRequest request) {
        service.changeLanguage(
                id,
                request.languageId()
        );
    }

    @Override
    public void changeRole(UUID id,
                           ChangeRoleRequest request) {
        service.changeRole(
                id,
                request.roleId()
        );
    }

    @Override
    public void changeTimezone(UUID id,
                               ChangeTimezoneRequest request) {
        service.changeTimezone(
                id,
                request.timezoneId()
        );
    }

    @Override
    public void migrateRole(MigrateRoleRequest request) {
        service.migrateUserRoles(
                request.pastRoleId(),
                request.newRoleId()
        );
    }

}
