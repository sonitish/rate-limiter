package io.github.sonitish.ratelimiter.types;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderCreateResponseTypes {
    String orderId;
    OrderStatus orderStatus;

    public enum OrderStatus{
        CREATED,ORDER_SUCCESS,ORDER_REJECTED;
    }

}
