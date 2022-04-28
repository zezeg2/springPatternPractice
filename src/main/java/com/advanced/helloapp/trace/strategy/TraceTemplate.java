package com.advanced.helloapp.trace.strategy;

import com.advanced.helloapp.trace.TraceStatus;
import com.advanced.helloapp.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class TraceTemplate {

    private final LogTrace trace;

    public <T> T execute(TraceCallBack<T> strategy, String message) {
        TraceStatus status = null;
        try {
            status = trace.begin(message);
            // 핵심 기능 호출
            T result = strategy.call();
            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

}
