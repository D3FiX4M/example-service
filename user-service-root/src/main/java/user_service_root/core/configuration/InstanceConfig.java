package user_service_root.core.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "instance")
public class InstanceConfig {
    private String key;
    private String id;

    private final String requestKeyName = "REQUEST-INSTANCE-KEY";
    private final String responseKeyName = "RESPONSE-INSTANCE-KEY";
    private final String requestIdName = "REQUEST-INSTANCE-ID";
    private final String responseIdName = "RESPONSE-INSTANCE-ID";
}
