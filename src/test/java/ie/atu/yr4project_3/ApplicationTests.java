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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ApplicationTests {

    @InjectMocks
    private NotificationService notificationService;

    @Mock
    private NotificationRepository notificationRepository;

    @Mock private NotificationClient notificationClient;

    @BeforeEach
    void setUp(){
        User mockUser = new User();
        mockUser.setUserId(321L);
        when(notificationClient.getUserId(321L)).thenReturn(mockUser);
    }

    @Test
    void testMessageForNotif() {
        Notification notification = new Notification(321L, "", "A");
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, ()-> notificationService.createNewNotification(notification));
        assertEquals("Message can't be blank", iae.getMessage());
    }

    @Test
    void testTypeForNotif() {
        Notification notification = new Notification(321L, "this is a message", "");
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, ()-> notificationService.createNewNotification(notification));
        assertEquals("Type can't be blank", iae.getMessage());
    }
}
