package com.advanced.helloapp.trace.logtrace;

import com.advanced.helloapp.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);

    void end(TraceStatus status);

    void exception(TraceStatus status, Exception e);

}
