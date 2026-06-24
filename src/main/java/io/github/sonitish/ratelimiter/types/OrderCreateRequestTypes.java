package io.github.sonitish.ratelimiter.types;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import jakarta.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class OrderCreateRequestTypes {
    String orderId;
    Double amount;
    @NotNull(message = "merchant id is required")
    String merchantId;
}
