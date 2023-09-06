package user_service_api.service;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import user_service_api.payload.request.*;
import user_service_api.payload.response.MultipleUserResponse;
import user_service_api.payload.response.UserResponse;
import user_service_api.router.UserRouter;

@LoadBalancerClient
@FeignClient("user-service")
public interface UserServiceFC {

    @PostMapping(UserRouter.CREATE)
    UserResponse create(@RequestBody CreateRequest request);

    @PostMapping(UserRouter.ROOT)
    MultipleUserResponse getByIds(@RequestBody GetByIdsRequest request);

    @PostMapping(UserRouter.ID.ROOT)
    UserResponse getById(@PathVariable Long id);

    @PostMapping(UserRouter.EMAIL)
    UserResponse getByEmail(@RequestBody GetByEmailRequest request);

    @PostMapping(UserRouter.ID.PASSWORD)
    void changePassword(@PathVariable Long id,
                        @RequestBody ChangePasswordRequest request);

    @PostMapping(UserRouter.ID.STATUS)
    void changeStatus(@PathVariable Long id,
                      @RequestBody ChangeStatusRequest request);

    @PostMapping(UserRouter.ID.LANGUAGE)
    void changeLanguage(@PathVariable Long id,
                        @RequestBody ChangeLanguageRequest request);

    @PostMapping(UserRouter.ID.ROLE)
    void changeRole(@PathVariable Long id,
                    @RequestBody ChangeRoleRequest request);

    @PostMapping(UserRouter.ID.TIMEZONE)
    void changeTimezone(@PathVariable Long id,
                        @RequestBody ChangeTimezoneRequest request);

    @PostMapping(UserRouter.MIGRATE_ROLE)
    void migrateRole(@RequestBody MigrateRoleRequest request);
}
