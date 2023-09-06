package user_service_api.payload.request;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChangeLanguageRequest {
    private Long languageId;
}
