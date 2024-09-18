package com.micro.productreservationinitsubscriber.externalConnectorImpl;


import com.micro.product.ProductionReservationInitiateMessage;
import com.micro.productService.ProductReservationInitRequest;
import com.micro.productService.ProductReservationInitResponse;
import com.micro.productService.ProductServiceGrpc;
import com.micro.productService.ReservedOrderItem;
import com.micro.productreservationinitsubscriber.externalConnector.ProductServiceHandler;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductServiceHandlerImpl implements ProductServiceHandler {

    @GrpcClient("product-service")
    ProductServiceGrpc.ProductServiceBlockingStub orderServiceBlockingStub;

    @Override
    public void sendMessageToProductService(ProductionReservationInitiateMessage productReservationRequest) {
        try{
            ProductReservationInitRequest productReservationInitRequest = ProductReservationInitRequest.newBuilder()
                    .setSagaId(productReservationRequest.getSagaId())
                    .addAllOrderItems(populateReservedOrderItem(productReservationRequest.getOrderItems()))
                    .build();
            ProductReservationInitResponse productReservationInitResponse =
                    orderServiceBlockingStub.initiateProductReservation(productReservationInitRequest);
        }catch (Exception ex){

        }
    }

    private List<com.micro.productService.ReservedOrderItem> populateReservedOrderItem(List<com.micro.product.ReservedOrderItem> orderItems){
        return orderItems.stream().map(reservedOrderItem ->
                com.micro.productService.ReservedOrderItem.newBuilder()
                        .setProductId(reservedOrderItem.getProductId())
                        .setAmount(reservedOrderItem.getAmount())
                        .setQuantity(reservedOrderItem.getQuantity())
                        .build()).collect(Collectors.toList());
    }
}
