package com.example.fitnessapp.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DataRepository extends CrudRepository<Data, Long> {
	List<Data> findByTitle(String title);
}
