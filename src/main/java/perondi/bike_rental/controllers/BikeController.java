package perondi.bike_rental.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import perondi.bike_rental.dto.request.BikeRequest;
import perondi.bike_rental.dto.response.BikeResponse;
import perondi.bike_rental.services.BikeService;

@Slf4j
@RestController
@RequestMapping("/bikes")
@RequiredArgsConstructor

public class BikeController {

    private final BikeService bikeService;

    @PostMapping
    public ResponseEntity<BikeResponse> registerBike(@Valid @RequestBody BikeRequest request) {
        log.info("POST /api/v1/bikes - Registering new bike");
        BikeResponse response = bikeService.registerBike(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
