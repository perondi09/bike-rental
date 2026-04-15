package perondi.bike_rental.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import perondi.bike_rental.dto.request.BikeRequest;
import perondi.bike_rental.dto.response.BikeResponse;
import perondi.bike_rental.entities.Bike;
import perondi.bike_rental.messaging.BikeEventPublisher;
import perondi.bike_rental.repositories.BikeRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class BikeService {

    private final BikeRepository bikeRepository;
    private final BikeEventPublisher bikeEventPublisher;

    public BikeResponse registerBike(BikeRequest request) {
        log.info("Registering bike with year: [{}], model: [{}]", request.getYear(), request.getModel());

        bikeRepository.findByPlate(request.getPlate()).ifPresent(existing -> {
            log.warn("Plate [{}] already exists", request.getPlate());
            throw new IllegalArgumentException("Plate already registered");
        });

        Bike bike = Bike.builder()
                .year(request.getYear())
                .model(request.getModel())
                .plate(request.getPlate())
                .build();

        Bike savedBike = bikeRepository.save(bike);
        log.info("Bike registered successfully with id: [{}]", savedBike.getId());

        bikeEventPublisher.publish(savedBike);

        return BikeResponse.builder()
                .id(savedBike.getId())
                .year(savedBike.getYear())
                .model(savedBike.getModel())
                .plate(savedBike.getPlate())
                .build();
    }
}
