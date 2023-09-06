package user_service_root.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import user_service_api.payload.request.*;
import user_service_api.payload.response.MultipleUserResponse;
import user_service_api.payload.response.UserResponse;
import user_service_api.router.UserRouter;
import user_service_root.domain.mapper.UserMapper;
import user_service_root.domain.service.UserService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserServiceWeb {

    private final UserService service;
    private final UserMapper mapper;

    @PostMapping(UserRouter.CREATE)
    UserResponse create(@RequestBody CreateRequest request) {
        return mapper.toUserResponse(
                service.create(
                        request.getEmail(),
                        request.getPassword(),
                        request.getRoleId(),
                        request.getLanguageId(),
                        request.getTimeZoneId()
                )
        );
    }

    @PostMapping(UserRouter.ROOT)
    MultipleUserResponse getByIds(@RequestBody GetByIdsRequest request) {
        return mapper.toMultipleUserResponse(
                service.getByIds(
                        request.getIds()
                )
        );
    }


    @PostMapping(UserRouter.ID.ROOT)
    UserResponse getById(@PathVariable UUID id) {
        return mapper.toUserResponse(
                service.getById(id)
        );
    }


    @PostMapping(UserRouter.EMAIL)
    UserResponse getByEmail(@RequestBody GetByEmailRequest request) {
        return mapper.toUserResponse(
                service.getByEmail(
                        request.getEmail()
                )
        );
    }


    @PostMapping(UserRouter.ID.PASSWORD)
    void changePassword(@PathVariable UUID id,
                        @RequestBody ChangePasswordRequest request) {
        service.changePassword(
                id,
                request.getPassword()
        );
    }


    @PostMapping(UserRouter.ID.STATUS)
    void changeStatus(@PathVariable UUID id,
                      @RequestBody ChangeStatusRequest request) {
        service.changeStatus(
                id,
                request.getStatus()
        );
    }


    @PostMapping(UserRouter.ID.LANGUAGE)
    void changeLanguage(@PathVariable UUID id,
                        @RequestBody ChangeLanguageRequest request) {
        service.changeLanguage(
                id,
                request.getLanguageId()
        );
    }

    @PostMapping(UserRouter.ID.ROLE)
    void changeRole(@PathVariable UUID id,
                    @RequestBody ChangeRoleRequest request) {
        service.changeRole(
                id,
                request.getRoleId()
        );
    }

    @PostMapping(UserRouter.ID.TIMEZONE)
    void changeTimezone(@PathVariable UUID id,
                        @RequestBody ChangeTimezoneRequest request) {
        service.changeTimezone(
                id,
                request.getTimezoneId()
        );
    }

    @PostMapping(UserRouter.MIGRATE_ROLE)
    void migrateRole(@RequestBody MigrateRoleRequest request) {
        service.migrateUserRoles(
                request.getPastRoleId(),
                request.getNewRoleId()
        );
    }

}
