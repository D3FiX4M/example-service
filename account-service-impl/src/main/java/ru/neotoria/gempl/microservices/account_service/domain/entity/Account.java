package ru.neotoria.gempl.microservices.account_service.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.neotoria.gempl.microservices.account_service.payload.constant.EAccountStatus;

import java.time.LocalDateTime;
import java.util.UUID;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EAccountStatus status;

    @Column(nullable = false)
    private Long roleId;

    @Column(nullable = false)
    private Long languageId;

    @Column(nullable = false)
    private Long timezoneId;

    @Column(nullable = false)
    private LocalDateTime createdAt;
}
