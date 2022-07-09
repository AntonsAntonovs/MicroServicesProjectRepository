package com.example.demo;

import com.example.demo.controller.NodeController;
import com.example.demo.service.NodeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

@WebMvcTest(NodeController.class)
public class NodesControllerTest{
    @Autowired
    MockMvc mockMvc;

    @MockBean
    NodeService nodeServiceMock;

    @Test
    public void testShowNodesSuccessfully() throws Exception {
        nodeServiceMock.getAllNodes();
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(xpath("//h3[contains(text(), 'Athlone')]").exists())
                .andExpect(xpath("//h3[contains(text(), 'Dublin')]").exists())
                .andExpect(xpath("//h3[contains(text(), 'node1')]").exists())
                .andExpect(xpath("//h3[contains(text(), 'node2')]").exists());
    }

}