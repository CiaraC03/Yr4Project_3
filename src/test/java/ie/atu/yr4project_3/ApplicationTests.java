package ie.atu.yr4project_3;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Incubating;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class ApplicationTests {

    @InjectMocks
    private NotificationService notificationService;

    @Mock
    private NotificationRepository notificationRepository;

    @BeforeEach
    void setUp(){
    }

    @Test
    void testMessageForNotif() {
        Notification notification = new Notification(1L, 321L, "", "A");
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, ()-> notificationService.createNewNotification(notification));
        assertEquals("Message cannot be blank", iae.getMessage());
    }

    @Test
    void testTypeForNotif() {
        Notification notification = new Notification(1L, 321L, "this is a message", "");
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, ()-> notificationService.createNewNotification(notification));
        assertEquals("Type cannot be blank", iae.getMessage());
    }
}
