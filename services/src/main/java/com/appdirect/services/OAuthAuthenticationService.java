package com.appdirect.services;

import com.appdirect.dto.EventDTO;

/**
 * Created by gaurav on 24/12/16.
 */
public interface OAuthAuthenticationService {
    EventDTO validatingRequestsFromAppDirect(String eventUrl);
}
