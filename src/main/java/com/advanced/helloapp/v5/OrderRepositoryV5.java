package com.advanced.helloapp.v5;


import com.advanced.helloapp.trace.logtrace.LogTrace;
import com.advanced.helloapp.trace.strategy.TraceTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor

public class OrderRepositoryV5 {

    private final TraceTemplate traceTemplate;

    public void save(String itemId) {

        ;
        traceTemplate.execute(() -> {
            if (itemId.equals("ex")) throw new IllegalStateException("예외 발생");
            sleep(1000);
            return null;
        },"OrderRepository.save()");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
