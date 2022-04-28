package com.advanced.helloapp.trace.strategy;

import com.advanced.helloapp.trace.strategy.code.strategy.ContextV1;
import com.advanced.helloapp.trace.strategy.code.strategy.StratageLogic1;
import com.advanced.helloapp.trace.strategy.code.strategy.StratageLogic2;
import com.advanced.helloapp.trace.strategy.code.strategy.Strategy;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {
    @DisplayName("1.stragageV1")
    @Test
    void test_1() {
        StratageLogic1 stratageLogic1 = new StratageLogic1();
        ContextV1 contextV1 = new ContextV1(stratageLogic1);
        contextV1.excute();

        StratageLogic2 stratageLogic2 = new StratageLogic2();
        ContextV1 contextV2 = new ContextV1(stratageLogic2);
        contextV1.excute();
    }

    @DisplayName("2.strategyV2")
    @Test
    void test_2() {
        Strategy strategy1 = new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직 1 실행");
            }
        };

        Strategy strategy2 = new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직 2 실행");
            }
        };

        ContextV1 contextV1 = new ContextV1(strategy1);
        ContextV1 contextV2 = new ContextV1(strategy2);

        contextV1.excute();
        contextV2.excute();
    }

    @DisplayName("3.strategyV3")
    @Test
    void test_3() {
        ContextV1 contextV1 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직 1 실행");
            }
        });

        ContextV1 contextV2 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직 2 실행");
            }
        });
        contextV1.excute();
        contextV2.excute();
    }

    @DisplayName("4.strategyV4")
    @Test
    void test_4() {
        ContextV1 contextV1 = new ContextV1(() -> log.info("비즈니스 로직 1 실행"));
        ContextV1 contextV2 = new ContextV1(() -> log.info("비즈니스 로직 2 실행"));
        contextV1.excute();
        contextV2.excute();
    }

}
