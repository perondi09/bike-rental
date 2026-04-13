package perondi.bike_rental.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BikeRequest {

    @NotNull(message = "Identifier is required")
    @JsonProperty("identifier")
    private Long identifier;

    @NotNull(message = "Year is required")
    @JsonProperty("year")
    private Integer year;

    @NotBlank(message = "Model is required")
    @JsonProperty("model")
    private String model;

    @NotBlank(message = "Plate is required")
    @JsonProperty("plate")
    private String plate;
}
