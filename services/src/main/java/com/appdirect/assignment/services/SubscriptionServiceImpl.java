package com.appdirect.assignment.services;

import com.appdirect.assignment.dto.EventDTO;
import com.appdirect.assignment.dto.EventResponseDTO;
import com.appdirect.assignment.enums.ErrorCode;
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
        EventDTO eventDTO = oAuthAuthenticationService.validatingRequestsFromAppDirect(eventUrl);
        EventResponseDTO eventResponseDTO = null;
        if(eventDTO==null) {
            eventResponseDTO = new EventResponseDTO(false, null, ErrorCode.UNKNOWN_ERROR, "Error During event creation");
        } else {
            eventResponseDTO = getEventResponseFromEvent(eventDTO);
        }



        return eventResponseDTO;
    }
    private EventResponseDTO getEventResponseFromEvent(EventDTO event) {
        EventResponseDTO eventResponse;
        switch (event.getType()){
            case SUBSCRIPTION_ORDER:
                eventResponse = handleSubscriptionCreation(event);
                break;
            case SUBSCRIPTION_CHANGE:
                eventResponse = handleSubscriptionChange(event);
                break;
            case SUBSCRIPTION_CANCEL:
                eventResponse = handleSubscriptionCancel(event);
                break;
            default:
                eventResponse = new EventResponseDTO(event.getType().name(),
                        "Successful event creation");
        }
        return eventResponse;
    }

    private EventResponseDTO handleSubscriptionCancel(EventDTO event) {
        return new EventResponseDTO(event.getPayload().getAccount().getAccountIdentifier(),
                "Successful subscription cancel");
    }

    private EventResponseDTO handleSubscriptionChange(EventDTO event) {
        return new EventResponseDTO(event.getPayload().getAccount().getAccountIdentifier(),
                "Successful subscription change");
    }

    private EventResponseDTO handleSubscriptionCreation(EventDTO event) {
        return new EventResponseDTO(event.getPayload().getCompany().getUuid(),
                "Successful subscription creation");
    }

}
