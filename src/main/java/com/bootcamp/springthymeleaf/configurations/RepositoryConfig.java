package com.bootcamp.springthymeleaf.configurations;

import com.bootcamp.springthymeleaf.repositories.PersonRepo;
import com.bootcamp.springthymeleaf.repositories.PersonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Bean
    public PersonRepo personRepo() {
        return new PersonRepository();
    }
}
