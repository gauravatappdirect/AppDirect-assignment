package com.appdirect.assignment;

import com.appdirect.assignment.dto.EventResponseDTO;
import com.appdirect.assignment.enums.ErrorCode;
import com.appdirect.assignment.services.EventServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by gaurav on 26/12/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EventServiceTest {
    @Autowired
    EventServiceImpl eventService;

    @Test
    public void testFalseUrl(){
        String eventUrl = "false url";
        EventResponseDTO responseDTO = eventService.handleEvent(eventUrl);
        Assert.assertEquals(ErrorCode.UNAUTHORIZED, responseDTO.getErrorCode());
    }

    @Test
    public void testWrongUrl(){
        String eventUrl = "http://appdirect.com";
        EventResponseDTO responseDTO = eventService.handleEvent(eventUrl);
        Assert.assertEquals(ErrorCode.UNKNOWN_ERROR, responseDTO.getErrorCode());
    }

}
