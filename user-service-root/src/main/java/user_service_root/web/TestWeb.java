package user_service_root.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import user_service_api.payload.request.GetByIdsRequest;
import user_service_api.payload.response.MultipleUserResponse;
import user_service_api.service.UserServiceFC;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
public class TestWeb {

    private final UserServiceFC userServiceFC;

    @GetMapping("/check")
    public MultipleUserResponse test() {
        return userServiceFC.getByIds(new GetByIdsRequest(new ArrayList<>()));
    }
}
