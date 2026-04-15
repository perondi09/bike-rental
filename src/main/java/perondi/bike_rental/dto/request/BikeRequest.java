package perondi.bike_rental.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class BikeRequest {

    @NotNull(message = "year is required")
    @JsonProperty("year")
    private Integer year;

    @NotBlank(message = "model is required")
    @JsonProperty("model")
    private String model;

    @NotBlank(message = "plate is required")
    @JsonProperty("plate")
    private String plate;
}
