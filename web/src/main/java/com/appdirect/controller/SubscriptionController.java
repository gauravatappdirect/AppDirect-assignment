package com.appdirect.controller;

import com.appdirect.dto.EventResponseDTO;
import com.appdirect.mapper.ViewMapper;
import com.appdirect.representation.EventResponseRepresentation;
import com.appdirect.services.SubscriptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gaurav on 23/12/16.
 */
@RestController
@RequestMapping(value = "/manageSubscription")
public class SubscriptionController {

    Logger logger = LoggerFactory.getLogger(SubscriptionController.class);

    @Autowired
    SubscriptionService subscriptionService;

    @Autowired
    ViewMapper viewMapper;

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody EventResponseRepresentation handleSubscriptionEvent(@RequestParam("eventUrl") String eventUlr){
        logger.debug("eventUrl : {}", eventUlr);
        EventResponseDTO eventResponseDTO = subscriptionService.handleSubscriptionEvent(eventUlr);
        return viewMapper.map(eventResponseDTO, EventResponseRepresentation.class);
    }
}
