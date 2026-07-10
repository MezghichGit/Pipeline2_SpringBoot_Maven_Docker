package com.ibcegos.app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnWelcomePage() throws Exception {

        mockMvc.perform(get("/home/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("home/bienvenue.html"));
    }

    @Test
    void shouldReturnAproposPage() throws Exception {

        mockMvc.perform(get("/home/apropos"))
                .andExpect(status().isOk())
                .andExpect(view().name("home/apropos.html"));
    }
    
    @Test
    void shouldReturnFormationsPageWithContent() throws Exception {

        mockMvc.perform(get("/home/formations"))
                .andExpect(status().isOk())
                .andExpect(view().name("home/formations.html"))
                .andExpect(content().string(org.hamcrest.Matchers.containsString(
                        "<h1 align=\"center\">Nos formations</h1>"
                )));
    }
}