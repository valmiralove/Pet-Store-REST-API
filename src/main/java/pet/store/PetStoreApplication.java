package pet.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This class starts Spring Boot. When Boot starts up, Hibernate creates the data tables. 
 */

@SpringBootApplication
public class PetStoreApplication {

	/**
	 * Starts Spring Boot.
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		SpringApplication.run(PetStoreApplication.class, args);
	}

}
