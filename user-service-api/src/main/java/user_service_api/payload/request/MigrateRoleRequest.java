package user_service_api.payload.request;

public record MigrateRoleRequest(
        Long pastRoleId,
        Long newRoleId
) {
}
