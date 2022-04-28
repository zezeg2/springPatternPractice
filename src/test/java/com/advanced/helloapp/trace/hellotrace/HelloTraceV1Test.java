package com.advanced.helloapp.trace.hellotrace;

import com.advanced.helloapp.trace.TraceStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

class HelloTraceV1Test {

    @DisplayName("1.begin_end Test")
    @Test
    void test_1() {
        // given
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("Hello");
        trace.end(status);
    }

    @DisplayName("2.begin_exception Test")
    @Test
    void test_2() {
        // given
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("Hello");
        trace.exception(status,new IllegalStateException());
    }

}