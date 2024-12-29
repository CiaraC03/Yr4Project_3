package ie.atu.yr4project_3;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NotificationController {

    private List<Notification> notificationList = new ArrayList<>();

    private NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService)
    {
        this.notificationService = notificationService;
    }

    @PostMapping("/notification")
    public ResponseEntity<List<Notification>> createNotification(@Valid @RequestBody Notification notification){
        notificationList = notificationService.createNewNotification(notification);
        return ResponseEntity.ok(notificationList);
    }

    @GetMapping("/notification/{userID]")
    public ResponseEntity<List<Notification>> notificationsByUserID(@PathVariable Long userId){
        return ResponseEntity.ok(notificationService.findNotificationsByUserID(userId));
    }

    @DeleteMapping("/delete/notifications/{userID]")
    public ResponseEntity<List<Notification>> deleteNotifications(@PathVariable Long id){
        List<Notification> notificationList = notificationService.deleteNotifications(id);
        return ResponseEntity.ok(notificationList);
    }

}
