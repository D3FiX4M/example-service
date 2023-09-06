package user_service_api.payload.request;

import user_service_api.payload.constant.EUserStatus;

public record ChangeStatusRequest(
        EUserStatus status
) {
}
