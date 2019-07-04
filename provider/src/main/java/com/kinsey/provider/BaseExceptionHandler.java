package com.kinsey.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Configuration
@ControllerAdvice
public class BaseExceptionHandler {
    private final Logger log = LoggerFactory.getLogger(BaseExceptionHandler.class);

    public BaseExceptionHandler() {
    }

    @ExceptionHandler(ServerErrorException.class)
    @ResponseBody
    public ApiErrorResponse springExceptionHandler(Throwable throwable) {
        this.log.warn(this.getClass().getName() + ":springExceptionHandler", throwable);
        ApiErrorResponse apiErrorResponse =new ApiErrorResponse(throwable.getMessage(), HttpStatus.BAD_REQUEST);
        return apiErrorResponse;
    }
}