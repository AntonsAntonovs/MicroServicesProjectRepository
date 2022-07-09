package com.example.demo.controller;

import com.example.demo.entity.Node;
import com.example.demo.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/nodes")
@RestController
public class NodeController {

    @Autowired
    NodeService nodeService;

    @GetMapping(value="/displayNodes",produces = {"application/json","application/xml"})
    public List<Node> displayNodes(Model model) {
        return nodeService.getAllNodes();
    }

    @GetMapping(value="/viewNode/{id}", produces={"application/json","application/xml"})
    public ResponseEntity<Node> viewNode(@PathVariable int id) {
        if (nodeService.getNode(id) == null)
            return ResponseEntity.notFound().build();
        else {
            Node result = nodeService.getNode(id);
            return ResponseEntity.ok().body(result);
        }
    }

    @PostMapping(consumes={"application/json","application/xml"},
            produces={"application/json","application/xml"})
    public ResponseEntity<Node> addNode(@RequestBody Node node) {
        System.out.println("Adding " + node);
        nodeService.addNode(node);
        URI uri = URI.create("/nodes/viewNode/" + node.getId());
        return ResponseEntity.created(uri).body(node);
    }

    @PutMapping(value="/updateNode/{id}", consumes={"application/json","application/xml"})
    public ResponseEntity updateNode(@PathVariable int id, @RequestBody Node node) {
        if (nodeService.getNode(id) == null) {
            nodeService.addNode(node);
            return ResponseEntity.notFound().build();
        } else {
            System.out.println("Updating item id " + id);
            nodeService.updateNode(node);
            return ResponseEntity.ok().build();
        }
    }

    @DeleteMapping("/deleteNode/{id}")
    public ResponseEntity deleteNode(@PathVariable int id) {
        if (nodeService.getNode(id) == null)
            return ResponseEntity.notFound().build();
        else {
            System.out.println("Deleting item id " + id);
            nodeService.deleteNode(id);
            return ResponseEntity.ok().build();
        }
    }

}
