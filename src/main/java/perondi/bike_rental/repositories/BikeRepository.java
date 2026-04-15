package perondi.bike_rental.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import perondi.bike_rental.entities.Bike;
import java.util.Optional;

public interface BikeRepository extends MongoRepository<Bike, String> {
    Optional<Bike> findByPlate(String plate);
}
