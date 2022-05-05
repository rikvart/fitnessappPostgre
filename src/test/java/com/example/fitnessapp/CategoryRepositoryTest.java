package com.example.fitnessapp;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.fitnessapp.model.Category;
import com.example.fitnessapp.model.CategoryRepository;

import org.junit.jupiter.api.Test;



@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository repository;

    @Test
    public void findByNameShouldReturnGategory() {
        List<Category> categories = repository.findByName("Run");
        
        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getName()).isEqualTo("Run");
    }
    
}