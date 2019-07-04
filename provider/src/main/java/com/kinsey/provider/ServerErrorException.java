package com.kinsey.provider;

public class ServerErrorException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ServerErrorException() {
        super("未能正确处理您的请求");
    }

    public ServerErrorException(String message) {
        super(message);
    }
}
