package com.springboot.docker.entities;

import org.springframework.context.annotation.Description;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Description(value = "Example Entity, only for demo purpose.")
@Entity
@Table(name = "example")
public class ExampleEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Column(name = "property_one", nullable = false)
    private String propertyOne;

    @NotNull
    @Column(name = "property_two", nullable = false)
    private String propertyTwo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPropertyOne() {
        return propertyOne;
    }

    public void setPropertyOne(String propertyOne) {
        this.propertyOne = propertyOne;
    }

    public String getPropertyTwo() {
        return propertyTwo;
    }

    public void setPropertyTwo(String propertyTwo) {
        this.propertyTwo = propertyTwo;
    }

    @Override
    public String toString()
    {
        return "ExampleEntity{" +
                "id=" + id +
                ", propertyOne='" + propertyOne + '\'' +
                ", propertyTwo='" + propertyTwo + '\'' +
                '}';
    }
}
