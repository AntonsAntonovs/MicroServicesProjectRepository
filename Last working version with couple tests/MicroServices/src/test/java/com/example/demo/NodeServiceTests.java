package com.example.demo;

import com.example.demo.entity.Node;
import com.example.demo.repo.NodeRepository;
import com.example.demo.service.NodeService;
import org.aspectj.apache.bcel.Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@SpringBootTest
public class NodeServiceTests {
    private Node testNode = new Node(0, "node1", "Athlone", 11,22);
    private Node testNode2 = new Node(1, "node2", "Dublin", 111,222);;
    @Autowired
    NodeService service;



    @MockBean
    private NodeRepository repositoryMock;


    @BeforeEach
    public void setUp(){
        Node node = (new Node(0, "node1", "Athlone", 11,22));
    }


    @Test
    public void addNewNode()	 {
        service.addNode(testNode = new Node(0, "node1", "Athlone", 11,22));
        verify(repositoryMock).save(testNode);
    }

    @Test
    public void removeNodeFromNodes()	 {
        //service.addNode(testNode = new Node(1, "node1", "Athlone", 11,22));
        service.deleteNode(1);
        verify(repositoryMock).deleteById(1);
    }

    @Test
    public void getAllNodeFromNodes(){
        service.getAllNodes();
        verify(repositoryMock).findAll();
    }



}