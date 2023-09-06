package user_service_api.payload.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetByEmailRequest {
    private String email;
}
