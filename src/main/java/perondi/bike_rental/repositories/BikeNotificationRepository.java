package perondi.bike_rental.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import perondi.bike_rental.entities.BikeNotification;

public interface BikeNotificationRepository extends MongoRepository<BikeNotification, String> {
}

