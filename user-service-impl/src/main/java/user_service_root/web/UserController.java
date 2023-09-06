package user_service_root.web;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import user_service_api.api.UserApi;
import user_service_api.payload.request.*;
import user_service_api.payload.response.UserMultipleResponse;
import user_service_api.payload.response.UserResponse;
import user_service_root.domain.mapper.UserMapper;
import user_service_root.domain.service.UserService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService service;
    private final UserMapper mapper;

    @Override
    public UserResponse create(CreateRequest request) {



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
    public UserMultipleResponse getByIds(GetByIdsRequest request) {
        return mapper.toMultipleUserResponse(
                service.getByIds(
                        request.ids()
                )
        );
    }


    @Override
    public UserResponse getById(UUID id) {
        return mapper.toUserResponse(
                service.getById(id)
        );
    }

    @Override
    public UserResponse getByEmail(GetByEmailRequest request) {
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
