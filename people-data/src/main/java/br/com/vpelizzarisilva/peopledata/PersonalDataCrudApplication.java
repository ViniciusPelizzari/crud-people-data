package br.com.vpelizzarisilva.peopledata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Vinícius Pelizzari
 */
@SpringBootApplication
public class PersonalDataCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalDataCrudApplication.class, args);
		System.out.println("OK - EM EXECUÇÃO!");
	}

}
