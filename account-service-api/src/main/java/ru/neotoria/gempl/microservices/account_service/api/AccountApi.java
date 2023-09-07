package ru.neotoria.gempl.microservices.account_service.api;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.neotoria.gempl.microservices.account_service.api.router.AccountServiceRouter;
import ru.neotoria.gempl.microservices.account_service.payload.request.*;
import ru.neotoria.gempl.microservices.account_service.payload.response.AccountMultipleResponse;
import ru.neotoria.gempl.microservices.account_service.payload.response.AccountResponse;

import java.util.UUID;

@LoadBalancerClient
@FeignClient("account-service")
public interface AccountApi {

    @PostMapping(AccountServiceRouter.CREATE)
    AccountResponse create(@RequestBody CreateRequest request);

    @PostMapping(AccountServiceRouter.ROOT)
    AccountMultipleResponse getByIds(@RequestBody GetByIdsRequest request);

    @PostMapping(AccountServiceRouter.ID.ROOT)
    AccountResponse getById(@PathVariable UUID id);

    @PostMapping(AccountServiceRouter.EMAIL)
    AccountResponse getByEmail(@RequestBody GetByEmailRequest request);

    @PostMapping(AccountServiceRouter.ID.PASSWORD)
    void changePassword(@PathVariable UUID id,
                        @RequestBody ChangePasswordRequest request);

    @PostMapping(AccountServiceRouter.ID.STATUS)
    void changeStatus(@PathVariable UUID id,
                      @RequestBody ChangeStatusRequest request);

    @PostMapping(AccountServiceRouter.ID.LANGUAGE)
    void changeLanguage(@PathVariable UUID id,
                        @RequestBody ChangeLanguageRequest request);

    @PostMapping(AccountServiceRouter.ID.ROLE)
    void changeRole(@PathVariable UUID id,
                    @RequestBody ChangeRoleRequest request);

    @PostMapping(AccountServiceRouter.ID.TIMEZONE)
    void changeTimezone(@PathVariable UUID id,
                        @RequestBody ChangeTimezoneRequest request);

    @PostMapping(AccountServiceRouter.MIGRATE_ROLE)
    void migrateRole(@RequestBody MigrateRoleRequest request);
}
