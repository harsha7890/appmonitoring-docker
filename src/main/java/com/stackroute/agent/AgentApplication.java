package com.stackroute.agent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
//@PropertySource("classpath:swagger.properties")
public class AgentApplication {
	static {
		String[] command3 = {"/bin/bash", "-c","docker pull google/cadvisor:latest"};
		try{
			Process proc2 = Runtime.getRuntime().exec(command3);
			System.out.println("alreadyexists1");
		} catch (Exception e2) {

			System.out.println("already exists");
		}
		String[] command2 = {"/bin/bash", "-c","docker rm cadvisor"};
		try{
			Process proc2 = Runtime.getRuntime().exec(command2);

		} catch (Exception e2) {

			System.out.println("running docker error");
		}
		String[] command = {"/bin/bash", "-c","docker rm cadvisor"};
		try{
			Process proc2 = Runtime.getRuntime().exec(command);

		} catch (Exception e2) {

			System.out.println("running docker error");
		}


	}

	public static void main(String[] args) {
		SpringApplication.run(AgentApplication.class, args);
	}
}
