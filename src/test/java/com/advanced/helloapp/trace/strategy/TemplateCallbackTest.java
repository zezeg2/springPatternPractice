package com.advanced.helloapp.trace.strategy;

import com.advanced.helloapp.trace.strategy.code.strategy.ContextV2;
import com.advanced.helloapp.trace.strategy.code.strategy.StratageLogic1;
import com.advanced.helloapp.trace.strategy.code.strategy.StratageLogic2;
import com.advanced.helloapp.trace.strategy.code.strategy.Strategy;
import com.advanced.helloapp.trace.strategy.code.strategy.template.CallBack;
import com.advanced.helloapp.trace.strategy.code.strategy.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {

    @DisplayName("2.contextV2 - inner")
    @Test
    void test_2() {
        TimeLogTemplate template = new TimeLogTemplate();
        template.excute(new CallBack() {
            @Override
            public void call() {
                log.info("비즈니스 로직 1 실행");
            }
        });
        template.excute(new CallBack() {
            @Override
            public void call() {
                log.info("비즈니스 로직 2 실행");
            }
        });
    }

    @DisplayName("2.contextV2 - lambda")
    @Test
    void test_3() {
        ContextV2 context = new ContextV2();
        TimeLogTemplate template = new TimeLogTemplate();
        template.excute(() -> log.info("비즈니스 로직 1 실행"));
        template.excute(() -> log.info("비즈니스 로직 2 실행"));
    }

}
