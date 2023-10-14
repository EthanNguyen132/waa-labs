package edu.miu.waa.lab8.exception;

public class RecordNotFoundException extends RuntimeException {

    public RecordNotFoundException(Exception e){
        super(e);
    }

    public RecordNotFoundException(String message){
        super(message);
    }
}
