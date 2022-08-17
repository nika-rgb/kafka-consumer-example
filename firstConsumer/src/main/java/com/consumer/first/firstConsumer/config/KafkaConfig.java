package com.consumer.first.firstConsumer.config;

import com.consumer.first.firstConsumer.model.OrderKafkaMessage;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConfig {
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServer;

    public final String CONSUMER_FACTORY = "consumerFactory";


    @Bean(CONSUMER_FACTORY)
    public ConsumerFactory<String, OrderKafkaMessage> consumerFactory() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(properties,
                new StringDeserializer(), new JsonDeserializer<>(OrderKafkaMessage.class, false));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, OrderKafkaMessage> kafkaListenerContainerFactory(@Qualifier(CONSUMER_FACTORY) ConsumerFactory<String, OrderKafkaMessage> consumerFactory) {
        ConcurrentKafkaListenerContainerFactory<String, OrderKafkaMessage> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }

}
