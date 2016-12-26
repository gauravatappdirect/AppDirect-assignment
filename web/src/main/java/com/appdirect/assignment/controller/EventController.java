package com.appdirect.assignment.controller;

import com.appdirect.assignment.dto.EventResponseDTO;
import com.appdirect.assignment.exceptions.ServiceException;
import com.appdirect.assignment.mapper.ViewMapper;
import com.appdirect.assignment.representation.EventResponseRepresentation;
import com.appdirect.assignment.services.EventService;
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
@RequestMapping("api/event/v1")
public class EventController {

    Logger logger = LoggerFactory.getLogger(EventController.class);

    @Autowired
    EventService eventService;

    @Autowired
    ViewMapper viewMapper;

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody EventResponseRepresentation handleEvent(@RequestParam("eventUrl") String eventUlr) throws ServiceException{
        logger.debug("eventUrl : {}", eventUlr);
        EventResponseDTO eventResponseDTO = eventService.handleEvent(eventUlr);
        return viewMapper.map(eventResponseDTO, EventResponseRepresentation.class);
    }
}
