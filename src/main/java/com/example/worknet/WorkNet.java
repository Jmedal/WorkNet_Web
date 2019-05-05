package com.example.worknet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.example.worknet.common.persistence.template.dao")
@EnableScheduling
public class WorkNet {
	public static void main(String[] args) {
		SpringApplication.run(WorkNet.class, args);
	}
}
