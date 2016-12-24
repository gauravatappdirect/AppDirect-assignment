package com.appdirect.assignment.dto;

import com.appdirect.assignment.enums.ErrorCode;

/**
 * Created by gaurav on 24/12/16.
 */
public class EventResponseDTO {
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

    public EventResponseDTO(String accountIdentifier, String message) {
        this.success = true;
        this.accountIdentifier = accountIdentifier;
        this.errorCode = null;
        this.message = message;
    }

    public EventResponseDTO(boolean success, String accountIdentifier, ErrorCode errorCode, String message) {
        this.success = success;
        this.accountIdentifier = accountIdentifier;
        this.errorCode = errorCode;
        this.message = message;
    }

    @Override
    public String toString() {
        return "EventResponse{" +
                "success=" + success +
                ", accountIdentifier='" + accountIdentifier + '\'' +
                ", errorCode=" + errorCode +
                ", message='" + message + '\'' +
                '}';
    }
}
