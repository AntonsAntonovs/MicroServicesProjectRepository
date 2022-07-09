package com.example.demo.serviceImpl;

import com.example.demo.entity.Node;
import com.example.demo.repo.NodeRepository;
import com.example.demo.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class NodeServiceImpl implements NodeService {

    @Autowired
    private NodeRepository nodeRepository;

//    @Value("#{nodes}")
//    private List<Node> nodeList;

    @Override
    public void addNode(Node node) {
        nodeRepository.save(node);
//        if (!nodeList.contains(node)) {
//            nodeList.add(node);
//        }
    }

    @Override
    public Node getNode(int id) {
        return nodeRepository.findById(id).get(0);
//        for(Node node : getAllNodes()) {
//            if(node.getId() == id) {
//                return node;
//            }
//        }
//
//        return null;
    }

    @Override
    public List<Node> getAllNodes() {
        return nodeRepository.findAll();
//        return nodeList;
    }

    @Override
    public void updateNode(Node node) {
        nodeRepository.save(node);
//        int id = -1;
//        for(Node curr : getAllNodes()) {
//            if(curr.getId() == node.getId()) {
//                id = curr.getId();
//            }
//        }
//
//        if(id == -1) {
//            nodeList.add(node);
//        } else {
//            nodeList.add(id, node);
//        }
    }

    @Override
    public void deleteNode(int id) {
        nodeRepository.deleteById(id);
//        for(Node node : getAllNodes()) {
//            if(node.getId() == id) {
//                nodeList.remove(node);
//                return;
//            }
//        }
    }
}
