package io.github.sonitish.ratelimiter.controller;


import io.github.sonitish.ratelimiter.algorithms.TokenBucketAlgorithm;
import io.github.sonitish.ratelimiter.service.OrderCreateService;
import io.github.sonitish.ratelimiter.types.OrderCreateRequestTypes;
import io.github.sonitish.ratelimiter.types.OrderCreateResponseTypes;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class OrderCreate{

    @Autowired
    OrderCreateService orderCreateService;


    @PostMapping("/order-create")

    public OrderCreateResponseTypes orderCreate(@Valid @RequestBody OrderCreateRequestTypes orderCreateRequest){
        String merchantId = orderCreateRequest.getMerchantId();
        try {
            TokenBucketAlgorithm.getToken();
        }
        catch (Exception e){
            throw new ResponseStatusException(
                    HttpStatus.TOO_MANY_REQUESTS,
                    "Too many requests"
            );
        }
        return orderCreateService.orderCreate(orderCreateRequest);
    }

}
