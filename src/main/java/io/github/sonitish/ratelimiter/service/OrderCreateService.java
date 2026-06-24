package io.github.sonitish.ratelimiter.service;

import io.github.sonitish.ratelimiter.types.OrderCreateRequestTypes;
import io.github.sonitish.ratelimiter.types.OrderCreateResponseTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class OrderCreateService {

    public OrderCreateResponseTypes orderCreate(OrderCreateRequestTypes orderCreateRequest){
        String orderId = orderCreateRequest.getOrderId();
        Double orderAmount = orderCreateRequest.getAmount();

        OrderCreateResponseTypes orderCreateResponse = new OrderCreateResponseTypes();
        orderCreateResponse.setOrderId(orderId);
        orderCreateResponse.setOrderStatus(OrderCreateResponseTypes.OrderStatus.CREATED);
        return orderCreateResponse;
    }
}
