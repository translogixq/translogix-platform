package de.shein.logix.controllers;

import de.shein.logix.entity.Users;
import de.shein.logix.repositories.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class Controller {

    private final Repository repository;


    public Controller(Repository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Users> list() {
        return repository.findAll();
    }


}
