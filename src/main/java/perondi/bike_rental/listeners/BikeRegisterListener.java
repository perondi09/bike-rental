package perondi.bike_rental.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import perondi.bike_rental.listeners.dto.BikeRegisterEvent;
import perondi.bike_rental.services.BikeService;

import static perondi.bike_rental.configurations.RabbitMqConfig.BIKE_QUEUE;

@Component
public class BikeRegisterListener {
    private final Logger logger = LoggerFactory.getLogger(BikeRegisterListener.class);

    private final BikeService bikeService;

    public BikeRegisterListener(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    @RabbitListener(queues = BIKE_QUEUE)
    public void listen(BikeRegisterEvent bikeRegisterEvent) {
        logger.info("Recebendo registro de bike: {}", bikeRegisterEvent);

        bikeService.register(bikeRegisterEvent);
    }
}
