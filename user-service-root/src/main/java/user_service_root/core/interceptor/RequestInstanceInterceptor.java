package user_service_root.core.interceptor;

import feign.InvocationContext;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.ResponseInterceptor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import user_service_root.core.configuration.InstanceConfig;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class RequestInstanceInterceptor implements RequestInterceptor, ResponseInterceptor {

    private final InstanceConfig config;

    @Override
    public void apply(RequestTemplate template) {
        template.header(config.getRequestKeyName(), config.getKey());
        template.header(config.getRequestIdName(), config.getId());
    }

    @Override
    public Object aroundDecode(InvocationContext invocationContext) throws IOException {

        Map<String, Collection<String>> headers = invocationContext
                .response()
                .headers();

        Collection<String> instanceKey = headers.get(config.getResponseKeyName());
        Collection<String> instanceId = headers.get(config.getResponseIdName());
        if (!instanceKey.isEmpty()) {
            instanceKey
                    .stream()
                    .findFirst()
                    .ifPresent(key -> log.info("Response instance name: " + key));
        }
        if (!instanceId.isEmpty()) {
            instanceId
                    .stream()
                    .findFirst()
                    .ifPresent(id -> log.info("Response instance id: " + id));
        }

        return invocationContext.proceed();
    }
}
