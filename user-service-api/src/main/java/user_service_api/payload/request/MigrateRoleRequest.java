package user_service_api.payload.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MigrateRoleRequest {
    private Long pastRoleId;
    private Long newRoleId;
}
