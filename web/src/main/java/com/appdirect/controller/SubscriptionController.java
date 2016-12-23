package com.appdirect.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gaurav on 23/12/16.
 */
@RestController
@RequestMapping(value = "/manageSubscription")
public class SubscriptionController {

    Logger logger = LoggerFactory.getLogger(SubscriptionController.class);
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void handleSubscriptionEvent(@RequestParam("eventUrl") String eventUlr){
        logger.debug("eventUrl : {}", eventUlr);
    }
}
