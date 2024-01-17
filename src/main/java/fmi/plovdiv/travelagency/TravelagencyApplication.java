package fmi.plovdiv.travelagency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TravelagencyApplication {

	public static void main(String[] args) {

		SpringApplication.run(TravelagencyApplication.class, args);
	}
}