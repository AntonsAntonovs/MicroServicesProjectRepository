package com.example.demo.repo;

import com.example.demo.entity.Node;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NodeRepository extends JpaRepository<Node, Integer> {

    List<Node> findAll();
    List<Node> findById(int id);


}
