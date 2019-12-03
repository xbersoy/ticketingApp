package com.finartz.caseStudy.ticketingSystem.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finartz.caseStudy.ticketingSystem.controller.AirportController;
import com.finartz.caseStudy.ticketingSystem.model.Airport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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
@WebMvcTest(AirportController.class)
public class AirportControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private AirportService airportService;


    @Test
    public void getByIdOK() throws Exception
    {
        Airport airport = new Airport();
        airport.setId(1L);
        airport.setName("test");
        airport.setCity("city");
        airport.setAlias("alias");
        Mockito.when(airportService.getById(1L)).thenReturn(airport);
        mvc.perform(MockMvcRequestBuilders
                .get("/airports/1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void saveEntityOK() throws Exception {
        Airport a1 = new Airport();
        a1.setId(1L);
        a1.setName("testName");
        a1.setCity("testCity");
        a1.setAlias("testAlias");

        String content = _getObjectAsJSONString(a1);

        mvc.perform(MockMvcRequestBuilders
                .post("/airports")
                .content(content).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void deleteOK() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .delete("/airports/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    private String _getObjectAsJSONString(Object object) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        return om.writeValueAsString(object);
    }
}