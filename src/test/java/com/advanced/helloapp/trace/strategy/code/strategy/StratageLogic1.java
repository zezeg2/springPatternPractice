package com.advanced.helloapp.trace.strategy.code.strategy;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StratageLogic1 implements Strategy {
    @Override
    public void call() {
        log.info("비즈니스 로직 1 실행");
    }


}
