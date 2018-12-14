package coop.tecso.examen;


import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {
	
	private static final Logger logger= Logger.getLogger(MainApplication.class);

	public static void main(final String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
	
}
