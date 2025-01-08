package ie.atu.yr4project_3;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListener {
    @RabbitListener(queues = "userQueue")
    public void NotificationsListener(User user){
        System.out.println(("Received message from User Service: " + user));
    }

}
