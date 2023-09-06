package user_service_api.payload.request;

public record CreateRequest(
        String email,
        String password,
        Long roleId,
        Long languageId,
        Long timeZoneId
) {
}
