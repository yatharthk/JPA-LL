package com.keysoft.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc()
public class TrackZillaControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void addApplication() throws Exception {
        String mockApplicationJson= "{\"name\":\"Test Application\",\"description\":\"A Test Application.\",\"owner\":\"Kesha Williams\"}";

        //Create a post request with accept header for application\json
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/tza/application")
                .accept(MediaType.APPLICATION_JSON).content(mockApplicationJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        //Assert that the return is Created
        assertEquals(HttpStatus.CREATED.value(),response.getStatus());

        //Get the location from the responseHeader and assert that it contains the URI of the created resource
        assertEquals("http://localhost/application/1",response.getHeader(HttpHeaders.LOCATION));

    }

    @Test
    public void findApplication() throws Exception {
        addApplication();

        //create a request
        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.get("/tza/application/1").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{\"id\":1,\"name\":\"Test Application\",\"description\":\"A Test Application.\",\"owner\":\"Kesha Williams\"}";

        //assert that response is what was expected
        assertEquals(expected,result.getResponse().getContentAsString());
    }

    @Test
    public void updateApplication() throws Exception {

        addApplication();

        String mockApplicationJson = "{\"id\":1,\"name\":\"Test Application Updated\",\"description\":\"An updated Test application.\",\"owner\":\"Kesha Williams\"}";

        //Create a put request with accept header for application\json
        RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/tza/application/")
                .accept(MediaType.APPLICATION_JSON).content(mockApplicationJson).contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{\"id\":1,\"name\":\"Test Application Updated\",\"description\":\"An updated Test application.\",\"owner\":\"Kesha Williams\"}";

        //assert that response is what was expected
        assertEquals(expected,result.getResponse().getContentAsString());
    }

    @Test
    public void deleteApplication() throws Exception {
        addApplication();

        String mockApplicationJson = "{\"id\":\"1\",\"name\":\"Test Application Updated\":\"description\":\"An updated Test Application\",\"owner\":\"Kesha Williams\"}";

        //Create a delete request with accept header for application/json
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/tza/application/1")
                .accept(MediaType.APPLICATION_JSON).content(mockApplicationJson).contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        //assert that return status is 204 NO content
        assertEquals(HttpStatus.NO_CONTENT.value(),response.getStatus());
    }

    @Test
    public void addTicket() throws Exception {
        addApplication();

        String mockTicketJson = "{\"title\":\"Multiple Assignees Needed\"," +
                "\"description\":\"There are cases where we need to assign a ticket to more than one person.\",\"application\":{\"id\":\"1\"},\"status\":\"Open\"}";

    RequestBuilder  requestBuilder = MockMvcRequestBuilders.post("/tza/ticket").accept(MediaType.APPLICATION_JSON)
            .content(mockTicketJson).contentType(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

    MockHttpServletResponse response = result.getResponse();

    //asset that response is 201 Created
    assertEquals(HttpStatus.CREATED.value(),response.getStatus());
    }

}
