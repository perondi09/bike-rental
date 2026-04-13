package perondi.bike_rental.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BikeResponse {

    @JsonProperty("identifier")
    private String identifier;

    @JsonProperty("year")
    private Integer year;

    @JsonProperty("model")
    private String model;

    @JsonProperty("plate")
    private String plate;
}
