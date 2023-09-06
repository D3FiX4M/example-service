package user_service_api.api;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import user_service_api.payload.request.*;
import user_service_api.payload.response.UserMultipleResponse;
import user_service_api.payload.response.UserResponse;
import user_service_api.router.UserServiceRouter;

import java.util.UUID;

@LoadBalancerClient
@FeignClient("user-service")
public interface UserApi {

    @PostMapping(UserServiceRouter.CREATE)
    UserResponse create(@RequestBody CreateRequest request);

    @PostMapping(UserServiceRouter.ROOT)
    UserMultipleResponse getByIds(@RequestBody GetByIdsRequest request);

    @PostMapping(UserServiceRouter.ID.ROOT)
    UserResponse getById(@PathVariable UUID id);

    @PostMapping(UserServiceRouter.EMAIL)
    UserResponse getByEmail(@RequestBody GetByEmailRequest request);

    @PostMapping(UserServiceRouter.ID.PASSWORD)
    void changePassword(@PathVariable UUID id,
                        @RequestBody ChangePasswordRequest request);

    @PostMapping(UserServiceRouter.ID.STATUS)
    void changeStatus(@PathVariable UUID id,
                      @RequestBody ChangeStatusRequest request);

    @PostMapping(UserServiceRouter.ID.LANGUAGE)
    void changeLanguage(@PathVariable UUID id,
                        @RequestBody ChangeLanguageRequest request);

    @PostMapping(UserServiceRouter.ID.ROLE)
    void changeRole(@PathVariable UUID id,
                    @RequestBody ChangeRoleRequest request);

    @PostMapping(UserServiceRouter.ID.TIMEZONE)
    void changeTimezone(@PathVariable UUID id,
                        @RequestBody ChangeTimezoneRequest request);

    @PostMapping(UserServiceRouter.MIGRATE_ROLE)
    void migrateRole(@RequestBody MigrateRoleRequest request);
}
