package com.appdirect.assignment;

import com.appdirect.assignment.controller.EventController;
import com.appdirect.assignment.dto.EventResponseDTO;
import com.appdirect.assignment.enums.ErrorCode;
import com.appdirect.assignment.mapper.ViewMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by gaurav on 26/12/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EventControllerTest {
    @Autowired
    EventController eventController;

    @Autowired
    ViewMapper viewMapper;

    @Test
    public void contextLoads() throws Exception {
        assertNotNull(eventController);
    }

    @Test
    public void malformedEventURLTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(this.eventController).build();
        ResultActions result= mockMvc.perform(get("/api/event/v1").param("eventUrl", "false url"))
                .andExpect(status().isOk());
        String json=result.andReturn().getResponse().getContentAsString();
        ObjectMapper mapper=new ObjectMapper();
        EventResponseDTO eventResponseDTO = mapper.readValue(json, EventResponseDTO.class);
        assertEquals(ErrorCode.UNAUTHORIZED,eventResponseDTO.getErrorCode());
        assertEquals("Malformed URL", eventResponseDTO.getMessage());
        assertEquals(Boolean.FALSE, eventResponseDTO.isSuccess());
    }

    @Test
    public void oAuthNotVerifiedTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(this.eventController).build();
        ResultActions result= mockMvc.perform(get("/api/event/v1").param("eventUrl", "http://www.google.com"))
                .andExpect(status().isOk());
        String json=result.andReturn().getResponse().getContentAsString();
        ObjectMapper mapper=new ObjectMapper();
        EventResponseDTO eventResponseDTO = mapper.readValue(json, EventResponseDTO.class);
        assertEquals(ErrorCode.UNKNOWN_ERROR,eventResponseDTO.getErrorCode());
        assertEquals("Error During event creation", eventResponseDTO.getMessage());
        assertEquals(Boolean.FALSE, eventResponseDTO.isSuccess());
    }
}
