package com.dig.leavemgmt.exception;

public class NoSuchRecordFoundException  extends RuntimeException{

    public NoSuchRecordFoundException(String msg){
        super(msg);
    }
    public NoSuchRecordFoundException(String msg,Throwable t){
        super(msg,t);
    }
}
