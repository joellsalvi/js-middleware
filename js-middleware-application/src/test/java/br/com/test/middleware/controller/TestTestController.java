package br.com.test.middleware.controller;

import br.com.middleware.application.Application;
import br.com.middleware.ws.api.ITestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ITestController.class)
@ContextConfiguration(classes = Application.class)
public class TestTestController {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;
    private HttpHeaders headers;

    @Before
    public void before() {
        objectMapper = new ObjectMapper();
        headers = new HttpHeaders();
        headers.add("X-Organization-Slug", "js-middleware");
        headers.add("X-Application-Id", "testController");
    }

    @Test
    public void widenet() throws Exception {
        mockMvc.perform(post("/test/widenet/{cep}", "cep")
                .param("cep", "38406-580")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": 1,\"name\":\"Joel\",\"lastName\":\"Salvi\",\"created\":null,\"birthday\":null}")
                .headers(headers)
        ).andExpect(status().isOk())
                .andExpect(content().string("{\"content\":{\"id\":1,\"fullName\":\"Joel Salvi\",\"address\":{\"code\":\"38406-580\",\"state\":\"MG\",\"city\":\"Uberlândia\",\"district\":\"Bosque dos Buritis\",\"address\":\"Alameda Ecológica\",\"complement\":null}}}"));
    }

    @Test
    public void viacep() throws Exception {
        mockMvc.perform(post("/test/viacep/{cep}", "cep")
                .param("cep", "38406-580")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": 1,\"name\":\"Joel\",\"lastName\":\"Salvi\",\"created\":null,\"birthday\":null}")
                .headers(headers)
        ).andExpect(status().isOk()).andExpect(content().string("{\"content\":{\"id\":1,\"fullName\":\"Joel Salvi\",\"address\":{\"code\":\"38406-580\",\"state\":\"MG\",\"city\":\"Uberlândia\",\"district\":\"Bosque dos Buritis\",\"address\":\"Alameda Ecológica\",\"complement\":\"\"}}}"));
    }

}
