package com.example.demo.serviceImpl;

import com.example.demo.entity.Node;
import com.example.demo.repo.NodeRepository;
import com.example.demo.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class NodeServiceImpl implements NodeService {

    @Autowired
    private NodeRepository nodeRepository;

    private List<Node> nodeList = new LinkedList<>();

    @Override
    public void addNode(Node node) {
        nodeRepository.save(node);
    }

    @Override
    public Optional<Node> getNode(int id) {
        return nodeRepository.findById(id);
    }

    @Override
    public void updateNode(Node node) {
        nodeRepository.save(node);
    }

    @Override
    public void deleteNode() {

    }
}
