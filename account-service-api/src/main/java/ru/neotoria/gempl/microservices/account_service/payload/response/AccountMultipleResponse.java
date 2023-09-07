package ru.neotoria.gempl.microservices.account_service.payload.response;

import java.util.List;


public record AccountMultipleResponse(
        List<AccountResponse> users
) {
}
