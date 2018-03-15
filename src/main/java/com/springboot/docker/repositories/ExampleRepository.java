package com.springboot.docker.repositories;

import com.springboot.docker.entities.ExampleEntity;
import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Description(value = "Example repository layer.")
@Repository
public interface ExampleRepository extends JpaRepository<ExampleEntity, Integer> { }
