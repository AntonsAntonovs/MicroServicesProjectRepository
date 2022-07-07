package com.example.demo.service;

import com.example.demo.entity.Node;

import java.util.Optional;

public interface NodeService {

    void addNode(Node node);
    Optional<Node> getNode(int id);
    void updateNode(Node node);
    void deleteNode();
}
