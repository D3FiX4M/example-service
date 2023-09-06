package user_service_api.payload.request;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdsRequest {
    private List<UUID> ids;
}
