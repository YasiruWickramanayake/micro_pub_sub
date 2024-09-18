package com.micro.productReserveInitPublisher.externalConnectorImpl;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.micro.product.ProductionReservationInitiateMessage;
import com.micro.productReserveInitPublisher.exceptions.ProductReservationPublisherException;
import com.micro.productReserveInitPublisher.externalConnector.ProductReservationKafkaPublisher;
import com.micro.productReserveInitPublisher.util.ErrorCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProductReservationKafkaPublisherImpl implements ProductReservationKafkaPublisher {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void publishProductInitiateKafkaMessage(ProductionReservationInitiateMessage productionReservationInitiateMessage) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonMessage = objectMapper.writeValueAsString(productionReservationInitiateMessage);
            kafkaTemplate.send("init-item-reservation", jsonMessage);
        } catch (Exception ex) {
            throw new ProductReservationPublisherException(ErrorCodes.PRODUCT_RESERVATION_MESSAGE_PUBLISH_ERROR_KAFKA.getErrorCode(),
                    ErrorCodes.PRODUCT_RESERVATION_MESSAGE_PUBLISH_ERROR_KAFKA.getMessage());
        }
    }
}
