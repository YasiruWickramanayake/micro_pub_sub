package com.micro.productReserveInitPublisher.serviceImpl;

import com.micro.orderService.ProductReservationInitRequest;

import com.micro.product.ProductionReservationInitiateMessage;
import com.micro.product.ReservedOrderItem;
import com.micro.productReserveInitPublisher.exceptions.ProductReservationPublisherException;
import com.micro.productReserveInitPublisher.externalConnector.ProductReservationKafkaPublisher;
import com.micro.productReserveInitPublisher.service.ProductReservationPublisherService;
import com.micro.productReserveInitPublisher.util.ErrorCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductReservationPublisherServiceImpl implements ProductReservationPublisherService {
    @Autowired
    private ProductReservationKafkaPublisher productReservationKafkaPublisher;

    @Override
    public void initiateProductReservation(ProductReservationInitRequest request) {
        try{
            ProductionReservationInitiateMessage productionReservationInitiateMessage =
                    generateReservationInitiateMessage(request);

            productReservationKafkaPublisher.publishProductInitiateKafkaMessage(productionReservationInitiateMessage);
        }catch (Exception ex){

        }
    }


    private ProductionReservationInitiateMessage generateReservationInitiateMessage(ProductReservationInitRequest request){
        try{
            return ProductionReservationInitiateMessage.builder()
                    .sagaId(request.getSagaId())
                    .orderItems(generateReservedOrderItemList(request.getOrderItemsList()))
                    .build();

        }catch (Exception ex){
            throw new ProductReservationPublisherException(ErrorCodes.PRODUCT_RESERVATION_INITIATE_MESSAGE_GENERATION_FAILED.getErrorCode(),
                    ErrorCodes.PRODUCT_RESERVATION_INITIATE_MESSAGE_GENERATION_FAILED.getMessage());
        }
    }

    private List<ReservedOrderItem> generateReservedOrderItemList(List<com.micro.orderService.ReservedOrderItem> orderItems){
        try{
            return orderItems.stream().map(reservedOrderItem -> ReservedOrderItem.builder()
                    .amount(reservedOrderItem.getAmount())
                    .quantity(reservedOrderItem.getQuantity())
                    .productId(reservedOrderItem.getProductId())
                    .build()).collect(Collectors.toList());
        }catch (Exception ex){
            throw new ProductReservationPublisherException(ErrorCodes.PRODUCT_RESERVATION_INITIATE_MESSAGE_GENERATION_FAILED.getErrorCode(),
                    ErrorCodes.PRODUCT_RESERVATION_INITIATE_MESSAGE_GENERATION_FAILED.getMessage());
        }
    }

}
