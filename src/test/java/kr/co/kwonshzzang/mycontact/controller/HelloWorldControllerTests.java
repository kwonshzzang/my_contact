package kr.co.kwonshzzang.mycontact.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HelloWorldControllerTests {
    @Autowired
    private HelloWorldController helloWorldController;

    private MockMvc mvc;

    @Test
    void helloWorld() {
        assertEquals(helloWorldController.helloWorld(), "HelloWorld");
    }

    @Test
    void mockMvcTest() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(helloWorldController).build();
        mvc.perform(
                MockMvcRequestBuilders.get("/api/helloWorld")
        ).andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("HelloWorld"));
    }

}