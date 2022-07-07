package com.example.demo.controller;

import com.example.demo.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/node")
public class NodeController {

    @Autowired
    NodeService nodeService;


    @GetMapping("/tutorials")
    public String home(Model model) {
        model.addAttribute("listNodes", nodeService.getAllNodes());
        return "index";
    }
//    @GetMapping

}
