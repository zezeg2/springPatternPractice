package com.advanced.helloapp.trace.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubClassLogic1  extends AbstractTemplate{
    @Override
    protected void call() {
        log.info("비즈니스로직 1 실행");
    }
}
