package com.advanced.helloapp.v5;

import com.advanced.helloapp.trace.logtrace.LogTrace;
import com.advanced.helloapp.trace.strategy.TraceTemplate;
import com.advanced.helloapp.trace.strategy.TraceCallBack;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV5 {

    private final OrderServiceV5 orderService;
    private final TraceTemplate traceTemplate;

    @GetMapping("/v5/request")
    public String request(String itemId) {
        return traceTemplate.execute((TraceCallBack<String>) () -> {
            orderService.orderItem(itemId);
            return "ok";
        }, "OrderController.request");
    }
}
