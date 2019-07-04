package com.kinsey.provider;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by dong_gui on 2019-07-03.
 */
@Data
public class ApiErrorResponse implements Serializable {

    private String timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
    private String exception;

    public ApiErrorResponse() {
        this.timestamp = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
    }

    public ApiErrorResponse(HttpStatus status) {
        this();
        this.status = status.value();
        this.message = status.name();
    }

    public ApiErrorResponse(String error, HttpStatus status) {
        this();
        this.status = status.value();
        this.message = status.name();
        this.error = error;
    }

    public ApiErrorResponse(String error, HttpStatus status, String path) {
        this();
        this.path = path;
        this.status = status.value();
        this.message = status.name();
        this.error = error;
    }

    public ApiErrorResponse(String error, HttpStatus status, String path, Exception exception) {
        this();
        this.path = path;
        this.status = status.value();
        this.message = status.name();
        this.error = error;
        this.exception = this.getExceptionMessage(exception);
    }

    public ApiErrorResponse(String error, HttpStatus status, Exception exception) {
        this();
        this.status = status.value();
        this.message = status.name();
        this.error = error;
        this.exception = this.getExceptionMessage(exception);
    }

    public ApiErrorResponse(String error, String message, HttpStatus status, String path, Exception exception) {
        this();
        this.path = path;
        this.status = status.value();
        this.message = message;
        this.error = error;
        this.exception = this.getExceptionMessage(exception);
    }

    public ApiErrorResponse(String error, String message, HttpStatus status, Exception exception) {
        this();
        this.status = status.value();
        this.message = message;
        this.error = error;
        this.exception = this.getExceptionMessage(exception);
    }

    private String getExceptionMessage(Throwable exception) {
        if (exception == null) {
            return "Internal Server Error, target exception is null";
        } else if (exception.getClass() == null) {
            return "Internal Server Error, target exception.getClass() is null";
        } else {
            String className = exception.getClass().getName();
            String InternalServerError = "未能正确处理您的请求";
            return StringUtils.isEmpty(className) ? InternalServerError : className;
        }
    }
}
