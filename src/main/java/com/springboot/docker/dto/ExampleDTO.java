package com.springboot.docker.dto;

import org.springframework.context.annotation.Description;

import java.io.Serializable;

@Description(value = "Example Data Transfer Object. Read only!")
public class ExampleDTO implements Serializable {

    private static final Long serialVersionUID = 1L;

    private String propOne;
    private String propTwo;

    public ExampleDTO() { }

    public ExampleDTO(String propOne, String propTwo)
    {
        this.propOne = propOne;
        this.propTwo = propTwo;
    }

    public String getPropOne() {
        return propOne;
    }

    public void setPropOne(String propOne) {
        this.propOne = propOne;
    }

    public String getPropTwo() {
        return propTwo;
    }

    public void setPropTwo(String propTwo) {
        this.propTwo = propTwo;
    }

    @Override
    public String toString()
    {
        return "ExampleDTO{" +
                "propOne='" + propOne + '\'' +
                ", propTwo='" + propTwo + '\'' +
                '}';
    }
}
