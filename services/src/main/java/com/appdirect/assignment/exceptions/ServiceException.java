package com.appdirect.assignment.exceptions;

import com.appdirect.assignment.dto.EventResponseDTO;
import com.appdirect.assignment.enums.ErrorCode;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by gaurav on 26/12/16.
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = -5580017022429522797L;

    @ExceptionHandler(ServiceException.class)
    public EventResponseDTO customRuntimeException(HttpServletRequest req, RuntimeException e){
        return new EventResponseDTO(false, null, ErrorCode.UNKNOWN_ERROR,
                "Runtime Error While processing event : "  + e.getMessage()+ " : " +req.getRequestURI());
    }
}

