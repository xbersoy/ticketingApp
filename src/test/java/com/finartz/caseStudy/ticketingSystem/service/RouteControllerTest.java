package com.finartz.caseStudy.ticketingSystem.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finartz.caseStudy.ticketingSystem.controller.AirportController;
import com.finartz.caseStudy.ticketingSystem.controller.RouteController;
import com.finartz.caseStudy.ticketingSystem.model.Airport;
import com.finartz.caseStudy.ticketingSystem.model.Route;
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
@WebMvcTest(RouteController.class)
public class RouteControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private RouteService routeService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getByIdOK() throws Exception {
        Route route = new Route();
        route.setId(1L);
        route.setAirportFrom(new Airport());
        route.setAirportTo(new Airport());


        Mockito.when(routeService.getById(1L)).thenReturn(route);
        mvc.perform(MockMvcRequestBuilders
                .get("/routes/1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void saveEntityOK() throws Exception {
        Route route = new Route();
        route.setId(1L);
        route.setAirportFrom(new Airport());
        route.setAirportTo(new Airport());

        String content = _getObjectAsJSONString(route);

        mvc.perform(MockMvcRequestBuilders
                .post("/routes")
                .content(content).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void deleteOK() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .delete("/routes/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    private String _getObjectAsJSONString(Object object) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        return om.writeValueAsString(object);
    }
}