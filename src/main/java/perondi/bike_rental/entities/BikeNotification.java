package perondi.bike_rental.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import java.time.LocalDateTime;

@Document(collection = "bike_notifications")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BikeNotification {

    @MongoId
    private String id;

    private String bikeId;

    private String model;

    private Integer year;

    private String plate;

    @Builder.Default
    private LocalDateTime receivedAt = LocalDateTime.now();

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
}
