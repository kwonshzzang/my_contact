package kr.co.kwonshzzang.mycontact.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class PersonControllerTests {
    @Autowired
    private PersonController personController;

    private MockMvc mvc;

    @Test
    void getPerson() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(personController).build();
        mvc.perform(
                MockMvcRequestBuilders.get("/api/person/1")
        )
                .andDo(print())
                .andExpect(status().isOk());

    }



}