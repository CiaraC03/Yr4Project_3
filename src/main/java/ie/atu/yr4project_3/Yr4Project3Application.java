package ie.atu.yr4project_3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Yr4Project3Application {

    public static void main(String[] args) {
        SpringApplication.run(Yr4Project3Application.class, args);
    }

}
