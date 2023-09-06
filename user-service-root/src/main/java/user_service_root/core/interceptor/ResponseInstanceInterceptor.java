package user_service_root.core.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import user_service_root.core.configuration.InstanceConfig;

@Slf4j
@Component
@RequiredArgsConstructor
public class ResponseInstanceInterceptor implements HandlerInterceptor {

    private final InstanceConfig config;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String instanceKey = request
                .getHeader(config.getRequestKeyName());
        String instanceId = request
                .getHeader(config.getRequestIdName());

        if (instanceKey != null) {
            log.info("Request instance name: " + instanceKey);

        }
        if (instanceId != null) {
            log.info("Request instance id: " + instanceId);
        }

        response.addHeader(config.getResponseKeyName(), config.getKey());
        response.addHeader(config.getResponseIdName(), config.getId());

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}