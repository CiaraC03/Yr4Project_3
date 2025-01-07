package ie.atu.yr4project_3;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "http://localhost:8080")
public interface NotificationClient {
    @GetMapping("/users/{userId}")
    User getUserId(@PathVariable Long userId);
}

