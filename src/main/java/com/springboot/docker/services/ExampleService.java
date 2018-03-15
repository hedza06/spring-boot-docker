package com.springboot.docker.services;

import com.springboot.docker.entities.ExampleEntity;
import com.springboot.docker.repositories.ExampleRepository;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Description(value = "Example service that is responsible for business logic.")
@Service
public class ExampleService {

    private ExampleRepository exampleRepository;

    /**
     * Constructor dependency injection.
     * @param exampleRepository - example repository layer.
     */
    public ExampleService(ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository;
    }

    /**
     * Method for getting example entity by id.
     *
     * @return Optional of ExampleEntity
     */
    public Optional<ExampleEntity> getOneExampleEntity(Integer id) {
        return exampleRepository.findById(id);
    }

}
