package ru.neotoria.gempl.microservices.account_service.payload.request;

public record CreateRequest(
        String email,
        String password,
        Long roleId,
        Long languageId,
        Long timeZoneId
) {
}
