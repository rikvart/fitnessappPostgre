package com.example.fitnessapp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.fitnessapp.model.Data;
import com.example.fitnessapp.model.DataRepository;
import com.example.fitnessapp.model.CategoryRepository;

import org.junit.jupiter.api.Test;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DataRepositoryTest {

	@Autowired
	private DataRepository repository;
	
	@Autowired
	private CategoryRepository crepository;

	@Test
	public void createNewData() {
		Data data = new Data("Töölönlahti", 145, 2, 20, crepository.findByName("Run").get(0));;
		repository.save(data);
		assertThat(data.getId()).isNotNull();
	}
	
	@Test
	public void findByTitle() {
		List<Data> alldata = repository.findByTitle("Töölönlahti");

		assertThat(alldata).hasSize(2);
		assertThat(alldata.get(0).getTitle()).isEqualTo("Töölönlahti");
	}

}
