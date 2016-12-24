package com.appdirect.assignment.representation;

import com.appdirect.assignment.enums.ErrorCode;

/**
 * Created by gaurav on 24/12/16.
 */
public class EventResponseRepresentation {
    private boolean success;
    private String accountIdentifier;
    private ErrorCode errorCode;
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getAccountIdentifier() {
        return accountIdentifier;
    }

    public void setAccountIdentifier(String accountIdentifier) {
        this.accountIdentifier = accountIdentifier;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
