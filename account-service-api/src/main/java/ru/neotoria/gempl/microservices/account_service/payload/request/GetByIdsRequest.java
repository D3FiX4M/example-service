package ru.neotoria.gempl.microservices.account_service.payload.request;

import java.util.List;
import java.util.UUID;

public record GetByIdsRequest(
        List<UUID> ids
) {
}
