package com.springjdbc.demo;

import com.springjdbc.demo.model.Alien;
import com.springjdbc.demo.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		ApplicationContext contex=SpringApplication.run(DemoApplication.class, args);
		Alien obj=(Alien)contex.getBean(Alien.class);
		obj.setId(1);
		obj.setName("chandu");
		obj.setTech("java");
		DemoRepository repo=contex.getBean(DemoRepository.class);
		repo.setData(obj);
		System.out.println(repo.getData());
	}

}
