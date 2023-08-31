package com.game.team3;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan
public class LwjTeam3Application {

	public static void main(String[] args) {
		SpringApplication.run(LwjTeam3Application.class, args);
	}

}
