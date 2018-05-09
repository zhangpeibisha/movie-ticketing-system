package org.nix.movieticketingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement // 加入事务注解
@ServletComponentScan
public class MovieTicketingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieTicketingSystemApplication.class, args);
	}
}
