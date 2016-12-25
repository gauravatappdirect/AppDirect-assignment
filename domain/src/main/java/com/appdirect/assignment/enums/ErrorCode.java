package com.appdirect.assignment.enums;

/**
 * Created by gaurav on 24/12/16.
 */
public enum ErrorCode {
    USER_ALREADY_EXISTS,
    USER_NOT_FOUND,
    ACCOUNT_NOT_FOUND,
    MAX_USERS_REACHED,
    UNAUTHORIZED,   //original creator to be unassigned
    OPERATION_CANCELED, // UI interrupt
    CONFIGURATION_ERROR, //endpoint is not currently configured
    INVALID_RESPONSE, //unable to process the event fetched from AppDirect.
    PENDING, //unable to process the event because the service is under provisioning.
    FORBIDDEN,
    BINDING_NOT_FOUND,
    TRANSPORT_ERROR, // server being unreachable.
    UNKNOWN_ERROR
}
