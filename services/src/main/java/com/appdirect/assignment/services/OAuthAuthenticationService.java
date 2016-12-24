package com.appdirect.assignment.services;

import com.appdirect.assignment.dto.EventDTO;

/**
 * Created by gaurav on 24/12/16.
 */
public interface OAuthAuthenticationService {
    EventDTO validatingRequestsFromAppDirect(String eventUrl);
}
