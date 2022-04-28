package com.advanced.helloapp.trace.logtrace;

import com.advanced.helloapp.trace.TraceStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FiledLogTraceTest {

    FiledLogTrace trace = new FiledLogTrace();

    @DisplayName("1.begin_end_level2")
    @Test
    void test_1() {
        // given
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        trace.end(status2);
        trace.end(status1);
        // when

        // then
    }

    @DisplayName("1.begin_exception_level2")
    @Test
    void test_2() {
        // given
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        trace.exception(status2, new IllegalStateException());
        trace.exception(status1, new IllegalStateException());
        // when

        // then
    }

}