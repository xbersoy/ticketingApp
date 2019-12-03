package com.finartz.caseStudy.ticketingSystem.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finartz.caseStudy.ticketingSystem.controller.AirlineController;
import com.finartz.caseStudy.ticketingSystem.controller.FlightController;
import com.finartz.caseStudy.ticketingSystem.controller.RouteController;
import com.finartz.caseStudy.ticketingSystem.model.Airline;
import com.finartz.caseStudy.ticketingSystem.model.Flight;
import com.finartz.caseStudy.ticketingSystem.model.Route;
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

import java.sql.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FlightController.class)
public class FlightControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private FlightService flightService;


    @org.junit.Test
    public void getByIdOK() throws Exception
    {

        Flight flightObject = new Flight();
        flightObject.setId(1L);
        flightObject.setAvailableSeat(50);
        flightObject.setTotalSeat(100);
        flightObject.setAirline(new Airline());
        flightObject.setArrivalDate(new Date(2019,12,22));
        flightObject.setDepartureDate(new Date(2019,12,22));
        flightObject.setFlightCode("TK-TEST");
        flightObject.setRoute(new Route());

        Mockito.when(flightService.getById(1L)).thenReturn(flightObject);
        mvc.perform(MockMvcRequestBuilders
                .get("/flights/1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @org.junit.Test
    public void saveEntityOK() throws Exception {

        Flight flightObject = new Flight();
        flightObject.setId(1L);
        flightObject.setAvailableSeat(50);
        flightObject.setTotalSeat(100);
        flightObject.setAirline(new Airline());
        flightObject.setArrivalDate(new Date(2019,12,22));
        flightObject.setDepartureDate(new Date(2019,12,22));
        flightObject.setFlightCode("TK-TEST");
        flightObject.setRoute(new Route());

        String content = _getObjectAsJSONString(flightObject);

        mvc.perform(MockMvcRequestBuilders
                .post("/flights")
                .content(content).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void deleteOK() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .delete("/flights/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    private String _getObjectAsJSONString(Object object) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        return om.writeValueAsString(object);
    }
}