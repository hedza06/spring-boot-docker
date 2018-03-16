package com.springboot.docker.services;

import com.springboot.docker.dto.ExampleDTO;
import com.springboot.docker.entities.ExampleEntity;
import com.springboot.docker.repositories.ExampleRepository;
import org.hibernate.transform.Transformers;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Description(value = "Example service that is responsible for business logic.")
@Service
public class ExampleService {

    @PersistenceContext
    private EntityManager entityManager;

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


    /**
     * Method for getting example by JPA typed query
     *
     * @param id - example identifier
     * @return Optional of Example Entity
     */
    public Optional<ExampleEntity> getExampleByTypedQuery(Integer id)
    {
        String query = "SELECT e FROM ExampleEntity e WHERE id = :id";
        TypedQuery<ExampleEntity> entityTypedQuery = entityManager.createQuery(query, ExampleEntity.class);
        entityTypedQuery.setParameter("id", id);

        return Optional.ofNullable(entityTypedQuery.getSingleResult());
    }

    /**
     * Method for getting list of examples with JPA native query
     *
     * @return List of Example Entity
     */
    @SuppressWarnings("unchecked")
    public List<ExampleEntity> getAllNative()
    {
        String nativeQuery = "SELECT id, property_one, property_two FROM example";
        Query query = entityManager.createNativeQuery(nativeQuery, ExampleEntity.class);

        return (List<ExampleEntity>) query.getResultList();
    }

    /**
     * Mapping native query to custom DTO class
     *
     * @return List of Example DTO
     */
    @SuppressWarnings("unchecked")
    public List<ExampleDTO> getAllDTO()
    {
        return entityManager.createNativeQuery("SELECT property_one as propOne, property_two as propTwo FROM example")
                .unwrap(org.hibernate.query.Query.class)
                .setResultTransformer(Transformers.aliasToBean(ExampleDTO.class))
                .getResultList();
    }
}
