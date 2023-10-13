package com.onionspring.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
}