package com.appdirect.services;

import com.appdirect.dto.EventResponseDTO;

/**
 * Created by gaurav on 24/12/16.
 */
public interface SubscriptionService {
    EventResponseDTO handleSubscriptionEvent(String eventUrl);
}
