package com.example.demo;

import com.example.demo.entity.Node;
import com.example.demo.repo.NodeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
//@EnableJpaRepositories(basePackageClasses= {NodeRepository.class})
@SpringBootApplication
public class MicroServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicesApplication.class, args);
	}


	@Bean
	@Scope("application")
	public List<Node> nodes() {
		List<Node> nodes = new ArrayList<>();
		nodes.add(new Node(0, "Node1", "Canada", 11,11));
		nodes.add(new Node(1, "Node2", "USA", 12, 22));

		return nodes;
	}
}
