package user_service_api.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import user_service_api.payload.constant.EUserStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private UUID id;
    private String email;
    private String password;
    private EUserStatus status;
    private Long roleId;
    private Long languageId;
    private Long timezoneId;
    private LocalDateTime createAt;
}
