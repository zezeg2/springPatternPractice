package com.advanced.helloapp.v5;

import com.advanced.helloapp.trace.logtrace.LogTrace;
import com.advanced.helloapp.trace.strategy.TraceTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class OrderServiceV5 {

    private final OrderRepositoryV5 orderRepository;
    private final TraceTemplate traceTemplate;

    public void orderItem(String itemId) {

        traceTemplate.execute(() -> {
            orderRepository.save(itemId);
            return null;
        },"OrderService.orderItem()");
    }
}
