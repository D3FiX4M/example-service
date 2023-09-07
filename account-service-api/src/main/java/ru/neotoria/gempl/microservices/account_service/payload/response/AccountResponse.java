package ru.neotoria.gempl.microservices.account_service.payload.response;

import ru.neotoria.gempl.microservices.account_service.payload.constant.EAccountStatus;

import java.time.LocalDateTime;
import java.util.UUID;


public record AccountResponse(
        UUID id,
        String email,
        String password,
        EAccountStatus status,
        Long roleId,
        Long languageId,
        Long timezoneId,
        LocalDateTime createAt
) {

}
