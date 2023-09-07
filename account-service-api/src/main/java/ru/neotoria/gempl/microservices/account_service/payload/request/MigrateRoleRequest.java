package ru.neotoria.gempl.microservices.account_service.payload.request;

public record MigrateRoleRequest(
        Long pastRoleId,
        Long newRoleId
) {
}
