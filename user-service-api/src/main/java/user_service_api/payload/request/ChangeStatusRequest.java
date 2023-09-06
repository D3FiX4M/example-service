package user_service_api.payload.request;

import lombok.*;
import user_service_api.payload.constant.EUserStatus;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChangeStatusRequest {
    private EUserStatus status;
}
