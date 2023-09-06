package user_service_root.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import user_service_api.payload.constant.EUserStatus;
import user_service_root.core.exception.GlobalError;
import user_service_root.core.exception.GlobalException;
import user_service_root.domain.entity.User;
import user_service_root.domain.repository.UserRepository;
import user_service_root.util.SHA1Generator;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User create(
            String email,
            String password,
            Long roleId,
            Long languageId,
            Long timezoneId
    ) {
        if (repository.existsByEmail(email)) {
            throw GlobalException.of(GlobalError.ALREADY_EXIST_ERROR);
        }

        return repository.save(
                new User(
                        UUID.randomUUID(),
                        email,
                        SHA1Generator.generateSHA1(password),
                        EUserStatus.NEW,
                        roleId,
                        languageId,
                        timezoneId,
                        LocalDateTime.now()
                )
        );
    }

    public List<User> getByIds(Collection<UUID> ids) {
        return repository.getEntityByIds(ids);
    }

    public User getById(UUID id) {
        return repository.getEntityById(id);
    }

    public User getByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> GlobalException.of(GlobalError.NOT_FOUND_ERROR));
    }

    public void changePassword(UUID userId, String password) {
        User user = getById(userId);
        user.setPassword(SHA1Generator.generateSHA1(password));
        repository.save(user);
    }

    public void changeStatus(UUID userId, EUserStatus status) {
        User user = getById(userId);
        user.setStatus(status);
        repository.save(user);
    }

    public void changeLanguage(UUID userId, Long languageId) {
        User user = getById(userId);
        user.setLanguageId(languageId);
        repository.save(user);
    }

    public void changeRole(UUID userId, Long roleId) {
        User user = getById(userId);
        user.setRoleId(roleId);
        repository.save(user);
    }

    public void changeTimezone(UUID userId, Long timezoneId) {
        User user = getById(userId);
        user.setTimezoneId(timezoneId);
        repository.save(user);
    }

    public void migrateUserRoles(Long prevRoleId, Long nextRoleId) {
        List<User> usersWithPrevRole = repository.findAllByRoleId(prevRoleId);

        usersWithPrevRole
                .forEach(user -> user.setRoleId(nextRoleId));

        repository.saveAll(usersWithPrevRole);
    }
}
