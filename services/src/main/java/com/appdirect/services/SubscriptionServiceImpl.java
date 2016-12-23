package com.appdirect.services;

import com.appdirect.dto.EventResponseDTO;
import com.appdirect.enums.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gaurav on 24/12/16.
 */
@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    OAuthAuthenticationService oAuthAuthenticationService;

    public EventResponseDTO handleSubscriptionEvent(String eventUrl) {
        oAuthAuthenticationService.validatingRequestsFromAppDirect(eventUrl);
        EventResponseDTO eventResponseDTO = new EventResponseDTO(false, null, ErrorCode.UNKNOWN_ERROR, "Error During event creation");

        return eventResponseDTO;
    }
}
