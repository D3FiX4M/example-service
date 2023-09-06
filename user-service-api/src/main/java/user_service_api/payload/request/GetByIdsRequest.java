package user_service_api.payload.request;

import java.util.List;
import java.util.UUID;

public record GetByIdsRequest(
        List<UUID> ids
) {
}
