package perondi.bike_rental.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import perondi.bike_rental.entities.Bike;

public interface BikeRepository extends MongoRepository<Bike, Long> {
}
