package ru.neotoria.gempl.microservices.account_service.payload.request;

import ru.neotoria.gempl.microservices.account_service.payload.constant.EAccountStatus;

public record ChangeStatusRequest(
        EAccountStatus status
) {
}
