package user_service_root.core.config;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Getter
@Component
public class InstanceConfig {

    private final EurekaClient eurekaClient;

    public InstanceConfig(EurekaClient eurekaClient) {

        InstanceInfo info = eurekaClient
                .getApplicationInfoManager()
                .getInfo();

        this.eurekaClient = eurekaClient;
        this.key = info.getAppName();
        this.id = info.getId();

        log.info("Instance started with key:" + key);
        log.info("Instance started with id:" + id);
    }

    private final String key;
    private final String id;
    private final String requestKeyName = "REQUEST-INSTANCE-KEY";
    private final String responseKeyName = "RESPONSE-INSTANCE-KEY";
    private final String requestIdName = "REQUEST-INSTANCE-ID";
    private final String responseIdName = "RESPONSE-INSTANCE-ID";
}
