package com.example.fitnessapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.fitnessapp.model.Data;
import com.example.fitnessapp.model.DataRepository;
import com.example.fitnessapp.model.Category;
import com.example.fitnessapp.model.CategoryRepository;
import com.example.fitnessapp.model.User;
import com.example.fitnessapp.model.UserRepository;



@SpringBootApplication
public class FitnessappApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitnessappApplication.class, args);
	};

	@Bean
	public CommandLineRunner fitnessDemo(DataRepository repository, CategoryRepository crepository,
			UserRepository urepository) {
		return (args) -> {
			System.out.println("Save new categories");
			crepository.save(new Category("Run"));
			crepository.save(new Category("Jog"));
			crepository.save(new Category("Walk"));
			System.out.println("Insert a excersise ");
			System.out.println("-------------------");
			repository.save(new Data("Töölönlahti", 145, 5, 30,
					crepository.findByName("Run").get(0)));
			repository.save(new Data("Lauttasaari", 145, 10, 60,
					crepository.findByName("Walk").get(0)));
			System.out.println("");
			System.out.println("Saving users in the userlog");
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			//urepository.save(user1);
			//urepository.save(user2);

			System.out.println("Excercises found with findAll():");
			System.out.println("-------------------------------");
			for (Data data : repository.findAll()) {
				System.out.println(data.toString());

			}

		};

	}
}
