package perondi.bike_rental.messaging;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BikeEvent {
    private String id;
    private Integer year;
    private String model;
    private String plate;
}
