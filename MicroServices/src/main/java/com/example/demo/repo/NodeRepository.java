package com.example.demo.repo;

import com.example.demo.entity.Node;
import org.springframework.data.repository.CrudRepository;

public interface NodeRepository extends CrudRepository<Node, Integer> {
}
