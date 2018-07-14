package sfmc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "sfmc.controller","sfmc.model", "sfmc.repository","sfmc.service", "sfmc.util", "sfmc.config"}) // define packages for scan
@EntityScan(basePackages = { "sfmc.model" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
