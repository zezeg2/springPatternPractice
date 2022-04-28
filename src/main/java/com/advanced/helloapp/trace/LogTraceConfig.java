package com.advanced.helloapp.trace;

import com.advanced.helloapp.trace.logtrace.FiledLogTrace;
import com.advanced.helloapp.trace.logtrace.LogTrace;
import com.advanced.helloapp.trace.logtrace.ThreadLocalLogTrace;
import com.advanced.helloapp.trace.strategy.TraceTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace(){
//        return new FiledLogTrace();
        return new ThreadLocalLogTrace();
    }

    @Bean
    public TraceTemplate traceTemplate(LogTrace trace){
        return new TraceTemplate(trace);
    }
}
