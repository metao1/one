package com.coyoapp.tinytask.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

/*
@Slf4j
public class ApplicationAsyncHandler implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
        log.error("Exception message - " + throwable.getMessage());
        log.error(("Method name - " + method.getName()));
        for (Object param : objects) {
            log.error(("Parameter value - " + param));
        }
    }
}*/
