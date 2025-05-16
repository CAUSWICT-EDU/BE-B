package cau.ict.btrack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
public class BtrackApplication {

	public static void main(String[] args) {
		SpringApplication.run(BtrackApplication.class, args);
	}

}
