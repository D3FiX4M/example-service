package user_service_root;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(
        basePackages = {
                "user_service_api.service"
        }
)
@SpringBootApplication
public class RootRunner {

    public static void main(String[] args) {
        SpringApplication.run(RootRunner.class, args);
    }

}
