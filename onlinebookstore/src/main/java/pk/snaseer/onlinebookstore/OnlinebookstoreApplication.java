package pk.snaseer.onlinebookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pk.snaseer.onlinebookstore.Validator.BookValidator;

@SpringBootApplication
public class OnlinebookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinebookstoreApplication.class, args);
	}

	@Bean
	public BookValidator beforeCreateBookValidator() {
		return new BookValidator();
	}


}
