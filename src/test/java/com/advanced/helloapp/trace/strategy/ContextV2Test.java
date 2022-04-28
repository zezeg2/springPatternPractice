package com.advanced.helloapp.trace.strategy;

import com.advanced.helloapp.trace.strategy.code.strategy.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {
    @DisplayName("1.contextV2")
    @Test
    void test_1() {
        ContextV2 context = new ContextV2();
        context.excute(new StratageLogic1());
        context.excute(new StratageLogic2());
    }

    @DisplayName("2.contextV2 - inner")
    @Test
    void test_2() {
        ContextV2 context = new ContextV2();
        context.excute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직 1 실행");
            }
        });
        context.excute(new Strategy() {
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
        context.excute(() -> log.info("비즈니스 로직 1 실행"));
        context.excute(() -> log.info("비즈니스 로직 2 실행"));
    }

}
