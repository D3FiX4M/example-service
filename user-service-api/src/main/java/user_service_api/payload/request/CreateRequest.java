package user_service_api.payload.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateRequest {
    private String email;
    private String password;
    private Long roleId;
    private Long languageId;
    private Long timeZoneId;
}
