package com.advanced.helloapp.trace.hellotrace;

import com.advanced.helloapp.trace.TraceStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloTraceV2Test {
    @DisplayName("1.begin_end Test")
    @Test
    void test_1() {
        // given
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status1 = trace.begin("Hello");
        TraceStatus status2 = trace.beginSync(status1.getTraceId(), "Hello2");
        trace.end(status2);
        trace.end(status1);
    }

    @DisplayName("2.begin_exception Test")
    @Test
    void test_2() {
        // given
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status1 = trace.begin("Hello");
        TraceStatus status2 = trace.beginSync(status1.getTraceId(), "Hello2");
        trace.exception(status2,new IllegalStateException());
        trace.exception(status1,new IllegalStateException());
    }
}