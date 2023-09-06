package user_service_root.domain.repository;

import org.springframework.stereotype.Repository;
import user_service_root.domain.entity.User;
import user_service_root.util.ExtendedRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends ExtendedRepository<User, UUID> {

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

    List<User> findAllByRoleId(Long roleId);
}
