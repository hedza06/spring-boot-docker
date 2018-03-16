package com.springboot.docker.endpoints;

import com.springboot.docker.dto.ExampleDTO;
import com.springboot.docker.entities.ExampleEntity;
import com.springboot.docker.services.ExampleService;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Description(value = "Endpoint only for demo purpose.")
@RestController
@RequestMapping(value = "/demo")
public class ExampleEndpoint {

    private ExampleService exampleService;

    /**
     * Constructor dependency injector.
     * @param exampleService - example service dependency layer.
     */
    public ExampleEndpoint(ExampleService exampleService) {
        this.exampleService = exampleService;
    }


    @GetMapping(value = "/example/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExampleEntity> getExampleModel(@PathVariable(value = "id") Integer id)
    {
        Optional<ExampleEntity> exampleEntity = exampleService.getOneExampleEntity(id);
        return exampleEntity
                .map(example -> new ResponseEntity<>(example, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping(value = "/example/typed/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExampleEntity> getExampleByTypedQuery(@PathVariable(value = "id") Integer id)
    {
        Optional<ExampleEntity> exampleEntity = exampleService.getExampleByTypedQuery(id);
        return exampleEntity
                .map(example -> new ResponseEntity<>(example, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping(value = "/example/native/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ExampleEntity>> getExampleListNative()
    {
        List<ExampleEntity> exampleEntityList = exampleService.getAllNative();
        return Optional.ofNullable(exampleEntityList)
                .map(exampleEntities -> new ResponseEntity<>(exampleEntities, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping(value = "/example/dto/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ExampleDTO>> getExampleDTOs()
    {
        List<ExampleDTO> exampleDTOList = exampleService.getAllDTO();
        return Optional.ofNullable(exampleDTOList)
                .map(exampleDTOS -> new ResponseEntity<>(exampleDTOS, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
