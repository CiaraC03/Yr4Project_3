package ie.atu.yr4project_3;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {

    private List<Notification> notificationList = new ArrayList<>();

    private NotificationRepository notificationRepository;

    private NotificationClient notificationClient;

    public NotificationService(NotificationRepository notificationRepository, NotificationClient notificationClient){
        this.notificationRepository = notificationRepository;
        this.notificationClient = notificationClient;
    }

    public List<Notification> createNewNotification(Notification notification){
        User user = notificationClient.getUserId(notification.getUserId());
        if (user == null) {
            throw new IllegalArgumentException("User with userId " + user.getUserId() + " does not exist.");
        }
        notificationRepository.save(notification);
        return notificationRepository.findAll();
    }

    public List<Notification> findNotificationsByUserID(Long userID){
        return notificationRepository.findByUserId(userID);
    }

    public List<Notification> deleteNotifications(Long id){
        if(notificationRepository.existsById(id)){
            notificationRepository.deleteById(id);
        }
        return null;
    }


}
