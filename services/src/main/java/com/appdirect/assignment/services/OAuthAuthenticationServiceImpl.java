package com.appdirect.assignment.services;

import com.appdirect.assignment.dto.EventDTO;
import org.scribe.exceptions.OAuthException;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;

import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

/**
 * Created by gaurav on 24/12/16.
 */
@Service
public class OAuthAuthenticationServiceImpl implements OAuthAuthenticationService {

    Logger logger = LoggerFactory.getLogger(OAuthAuthenticationServiceImpl.class);

    @Autowired
    OAuthService appDirectOAuthService;

    @Autowired
    Jaxb2Marshaller marshaller;

    @Autowired
    private Token appDirectToken;

    public EventDTO validatingRequestsFromAppDirect(String eventUrl) throws OAuthException {
        OAuthRequest request = new OAuthRequest(Verb.GET, eventUrl);
        appDirectOAuthService.signRequest(appDirectToken, request);
        Response responseFromAppDirect = request.send();
        int errorCodeFromOAuth = responseFromAppDirect.getCode();
        EventDTO eventDTO = null;
        if(errorCodeFromOAuth>=200 && errorCodeFromOAuth<300){
            try {
                eventDTO= (EventDTO) marshaller.unmarshal(new StreamSource(
                        new ByteArrayInputStream(responseFromAppDirect.getBody().getBytes("utf-8"))));

            } catch (UnsupportedEncodingException e) {
                logger.error("UnsupportedEncodingException {}",e);
            }
        }
        return eventDTO;
    }
}
