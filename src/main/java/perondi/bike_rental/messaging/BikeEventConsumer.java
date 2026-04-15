package perondi.bike_rental.messaging;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import perondi.bike_rental.configurations.RabbitMqConfig;
import perondi.bike_rental.entities.BikeNotification;
import perondi.bike_rental.repositories.BikeNotificationRepository;
import java.time.LocalDateTime;

@Slf4j
@Component
@RequiredArgsConstructor
public class BikeEventConsumer {

    private final BikeNotificationRepository bikeNotificationRepository;

    @RabbitListener(queues = RabbitMqConfig.QUEUE_NAME)
    public void onBikeRegistred(BikeEvent event) {
        log.info("Received bike.registred event: id=[{}], year=[{}]",
                event.getId(), event.getYear());

        if (event.getYear() != null && event.getYear() == 2024) {
            BikeNotification notification = BikeNotification.builder()
                    .bikeId(event.getId())
                    .plate(event.getPlate())
                    .year(event.getYear())
                    .model(event.getModel())
                    .receivedAt(LocalDateTime.now())
                    .build();

            bikeNotificationRepository.save(notification);
            log.info("Stored 2024 bike notification: id=[{}], plate=[{}]",
                    event.getId(), event.getPlate());
        } else {
            log.debug("Bike year [{}] is not 2024, skipping notification", event.getYear());
        }
    }
}

