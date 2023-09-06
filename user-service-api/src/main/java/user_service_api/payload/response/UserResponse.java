package user_service_api.payload.response;

import user_service_api.payload.constant.EUserStatus;

import java.time.LocalDateTime;
import java.util.UUID;


public record UserResponse(
        UUID id,
        String email,
        String password,
        EUserStatus status,
        Long roleId,
        Long languageId,
        Long timezoneId,
        LocalDateTime createAt
) {

}
