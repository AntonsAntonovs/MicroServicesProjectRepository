package com.example.demo.service;

import com.example.demo.entity.Node;

import java.util.List;

public interface NodeService {

    void addNode(Node node);

    Node getNode(int id);
    List<Node> getAllNodes();
    void updateNode(Node node);
    void deleteNode(int id);
}
