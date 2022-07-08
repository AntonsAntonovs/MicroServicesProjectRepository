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
    private Node testNode;
    @Autowired
    NodeService service;

    @MockBean
    private NodeRepository repositoryMock;


    @BeforeEach
    public void setUp(){
        Node node = (new Node(10, "node1", "Athlone", 11,22));
    }
//    @Test
//    public void nodesHas6Elements()	 {
//        int actual = service.getAllNodes().size();
//        int expected = 6;
//        assertEquals(expected, actual);
//    }
    @Test
    public void addNewNode()	 {
        service.addNode(testNode = new Node(0, "node1", "Athlone", 11,22));
        verify(repositoryMock).save(testNode);
    }
    @Test
    public void addNewNode_invalidNodeId_itemNotAddedToNodes()	 {
        service.addNode(testNode = new Node(9999, "node1", "Athlone", 11,22));
        verify(repositoryMock, times(0)).add(0, "node1", "Athlone", 11,22);
    }
    @Test
    public void removeNodeFromNodes()	 {
        service.deleteNode(1);
        verify(repositoryMock).delete(1);
    }
}
