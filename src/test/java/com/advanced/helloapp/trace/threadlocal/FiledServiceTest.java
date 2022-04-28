package com.advanced.helloapp.trace.threadlocal;


import com.advanced.helloapp.trace.threadlocal.code.FiledService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class FiledServiceTest {

    private FiledService filedService = new FiledService();

    @DisplayName("1.filed")
    @Test
    void test_1() {
        log.info("mainStart");
        Runnable userA = () ->{
            filedService.logic("userA");
        };

        Runnable userB = () ->{
            filedService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("Thread A");
        Thread threadB = new Thread(userB);
        threadB.setName("Thread B");

        threadA.start();
//        sleep(2000); // 동시성 문제 발생 X
        sleep(100); // 동시성 문제 발생 O
        threadB.start();
        sleep(2000);
        log.info("mainExit");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
