package ie.atu.yr4project_3;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "task-service", url = "${feign.user-service.url}")
public interface NotificationClient {
    @GetMapping("/{Id}")
    String getTaskById(@PathVariable Long userId);
}
