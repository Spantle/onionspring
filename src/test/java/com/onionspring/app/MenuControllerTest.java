package com.onionspring.app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class MenuControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testShowAvailableItems() throws Exception {
        mockMvc.perform(get("/menu"))
                .andExpect(status().isOk())
                .andExpect(view().name("menu"))
                .andExpect(model().attributeExists("items"));
    }

    @Test
    public void testShowShreghetti() throws Exception {
        mockMvc.perform(get("/shreghetti"))
                .andExpect(status().isOk())
                .andExpect(view().name("shreghetti"));
    }

    @Test
    public void testShowCrustyCrabbyBaguette() throws Exception {
        mockMvc.perform(get("/crusty-crabby-baguette"))
                .andExpect(status().isOk())
                .andExpect(view().name("crusty-crabby-baguette"));
    }

    @Test
    public void testShowPeppasSnaughtySnacks() throws Exception {
        mockMvc.perform(get("/peppa’s-snaughty-snacks"))
                .andExpect(status().isOk())
                .andExpect(view().name("peppa’s-snaughty-snacks"));
    }

    @Test
    public void testShowPoptards() throws Exception {
        mockMvc.perform(get("/poptards"))
                .andExpect(status().isOk())
                .andExpect(view().name("poptards"));
    }
}