package com.example.bookstorefall2020;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstorefall2020.model.Book;
import com.example.bookstorefall2020.model.BookRepository;

@SpringBootApplication
public class BookstoreFall2020Application {

	private static final Logger log = LoggerFactory.getLogger(BookstoreFall2020Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreFall2020Application.class, args);
	}
	@Bean
	public CommandLineRunner studentDemo(BookRepository repository) {
		return (args) -> {
			

			log.info("save a couple of books");
			repository.save(new Book("The Capital", "Marx", 1890, "123-234", 99.90));
			repository.save(new Book("Nykypaivien Saksa", "Sven", 1935, "123-2346", 9.7));	
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
	
}
