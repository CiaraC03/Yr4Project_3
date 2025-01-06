package ie.atu.yr4project_3;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "notification")
public class Notification {
    @Id
    private Long id;
    @NotNull(message = "ID cant be null")
    private Long userId;
    @NotBlank(message = "Message can't be blank")
    private String message;
    @NotBlank(message = "Notification can't be blank")
    private String type;
}
