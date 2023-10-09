package edu.miu.waa.lab5.exception;

public class InvalidRecordException extends RuntimeException {

    public InvalidRecordException(Exception e){
        super(e);
    }

    public InvalidRecordException(String message){
        super(message);
    }
}
