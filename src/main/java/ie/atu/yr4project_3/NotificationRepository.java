package ie.atu.yr4project_3;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NotificationRepository extends MongoRepository <Notification, Long> {
    List<Notification> findByUserId(Long userId);

}
