package user_service_api.payload.response;

import java.util.List;


public record UserMultipleResponse(
        List<UserResponse> users
) {
}
