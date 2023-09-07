package ru.neotoria.gempl.microservices.account_service.payload.constant;

public enum EAccountStatus {
    BLOCKED,
    NEW,
    ACTIVE,
    REQUIRED_EMAIL_VERIFICATION,
    REQUIRED_ADMIN_VERIFICATION
}
