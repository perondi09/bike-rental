package perondi.bike_rental.services;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import perondi.bike_rental.entities.Bike;
import perondi.bike_rental.listeners.dto.BikeRegisterEvent;
import perondi.bike_rental.repositories.BikeRepository;

@Service

public class BikeService {

    private final BikeRepository bikeRepository;
    private final MongoTemplate mongoTemplate;

    public BikeService(BikeRepository bikeRepository, MongoTemplate mongoTemplate) {
        this.bikeRepository = bikeRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public void register(BikeRegisterEvent bikeRegisterEvent) {

        var bike = new Bike();

        bike.setIdentifier(bikeRegisterEvent.identifier());
        bike.setYear(bikeRegisterEvent.year());
        bike.setModel(bikeRegisterEvent.model());
        bike.setPlate(bikeRegisterEvent.plate());

        bikeRepository.save(bike);
    }
}
