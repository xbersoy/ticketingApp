package com.finartz.caseStudy.ticketingSystem.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finartz.caseStudy.ticketingSystem.controller.AirlineController;
import com.finartz.caseStudy.ticketingSystem.model.Airline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AirlineController.class)
public class AirlineControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private AirlineService airlineService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getByIdOK() throws Exception {
        Airline a1 = new Airline();
        a1.setId(1L);
        a1.setName("test");


        Mockito.when(airlineService.getById(1L)).thenReturn(a1);
        mvc.perform(MockMvcRequestBuilders
                .get("/airlines/1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void saveEntityOK() throws Exception {
        Airline a1 = new Airline();
        a1.setId(1L);
        a1.setName("test");

        String content = _getObjectAsJSONString(a1);

        mvc.perform(MockMvcRequestBuilders
        .post("/airlines")
        .content(content).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void deleteOK() throws Exception {
        mvc.perform(MockMvcRequestBuilders
            .delete("/airlines/1")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }

    private String _getObjectAsJSONString(Object object) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        return om.writeValueAsString(object);
    }

}