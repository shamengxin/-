package com.shamengxin.bank.exceptions;

/**
 * 转帐异常
 */
public class TransferException extends Exception{
    public TransferException() {

    }

    public TransferException(String message) {
        super(message);
    }
}
