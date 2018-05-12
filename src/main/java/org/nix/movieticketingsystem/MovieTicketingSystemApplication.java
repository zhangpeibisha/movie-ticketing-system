package org.nix.movieticketingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * repositories
 */
@SpringBootApplication
@EnableJpaRepositories("org.nix.movieticketingsystem.pojo.dao")
@ComponentScan(basePackages = "org.nix.movieticketingsystem")
@EntityScan("org.nix.movieticketingsystem.pojo.entity")
public class MovieTicketingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieTicketingSystemApplication.class, args);
	}
}
