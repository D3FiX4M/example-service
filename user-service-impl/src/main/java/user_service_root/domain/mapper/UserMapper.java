package user_service_root.domain.mapper;

import org.springframework.stereotype.Component;
import user_service_api.payload.response.UserMultipleResponse;
import user_service_api.payload.response.UserResponse;
import user_service_root.domain.entity.User;

import java.util.Collection;

@Component
public class UserMapper {

    public UserResponse toUserResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getStatus(),
                user.getRoleId(),
                user.getLanguageId(),
                user.getTimezoneId(),
                user.getCreatedAt()
        );
    }

    public UserMultipleResponse toMultipleUserResponse(Collection<User> users) {
        return new UserMultipleResponse(
                users
                        .stream()
                        .map(this::toUserResponse)
                        .toList()
        );

    }
}