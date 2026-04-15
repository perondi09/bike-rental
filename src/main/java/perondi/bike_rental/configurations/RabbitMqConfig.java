package perondi.bike_rental.configurations;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    public static final String EXCHANGE_NAME = "bike.exchange";
    public static final String QUEUE_NAME = "bike.register";
    public static final String ROUTING_KEY = "bike.registred";

    @Bean
    public TopicExchange motoExchange() {
        return new TopicExchange(EXCHANGE_NAME, true, false);
    }


    @Bean
    public Queue motoQueue() {
        return QueueBuilder.durable(QUEUE_NAME).build();
    }

    @Bean
    public Binding motoBinding(Queue motoQueue, TopicExchange motoExchange) {
        return BindingBuilder.bind(motoQueue).to(motoExchange).with(ROUTING_KEY);
    }

    @Bean
    public JacksonJsonMessageConverter jacksonMessageConverter() {
        return new JacksonJsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(jacksonMessageConverter());
        return template;
    }
}
