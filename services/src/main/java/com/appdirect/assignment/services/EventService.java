package com.appdirect.assignment.services;

import com.appdirect.assignment.dto.EventResponseDTO;

/**
 * Created by gaurav on 24/12/16.
 */
public interface EventService {
    EventResponseDTO handleEvent(String eventUrl);
}
