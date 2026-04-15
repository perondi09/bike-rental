package perondi.bike_rental.messaging;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import perondi.bike_rental.configurations.RabbitMqConfig;
import perondi.bike_rental.entities.Bike;

@Slf4j
@Component
@RequiredArgsConstructor
public class BikeEventPublisher {

    private final RabbitTemplate rabbitTemplate;

    public void publish(Bike bike) {
        BikeEvent event = BikeEvent.builder()
                .id(bike.getId())
                .year(bike.getYear())
                .model(bike.getModel())
                .plate(bike.getPlate())
                .build();

        log.info("Publishing bike.cadastrada event for bike [{}] year [{}]",
                bike.getId(), bike.getYear());

        rabbitTemplate.convertAndSend(
                RabbitMqConfig.EXCHANGE_NAME,
                RabbitMqConfig.ROUTING_KEY,
                event
        );

        log.debug("Event published successfully for bike [{}]", bike.getId());
    }
}
