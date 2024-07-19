package com.example.sweetsbook.sweet;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;


@Controller
public class SweetController {
    
    private final SweetRepository sweetRepository;
    
    public SweetController(SweetRepository sweetRepository) {
        this.sweetRepository = sweetRepository;
    }
    
    @QueryMapping    
    public Iterable<Sweet> sweets() {
        return sweetRepository.findAll();
    }
    @QueryMapping
    public Sweet sweetById(@Argument Long id) {
        return sweetRepository.findById(id).orElse(null);
    }
   
}
