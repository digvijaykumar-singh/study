package com.dig.leavemgmt.exception;

public class ServiceException extends  RuntimeException{
    public  ServiceException(String str){
        super(str);
    }
    public ServiceException(String message, Throwable root) {
        super(message, root);
    }
}
