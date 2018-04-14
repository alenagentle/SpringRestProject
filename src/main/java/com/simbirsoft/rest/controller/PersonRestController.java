package com.simbirsoft.rest.controller;

import com.simbirsoft.rest.dto.PersonDto;
import com.simbirsoft.rest.dto.ShortPerson;
import com.simbirsoft.rest.repo.PersonRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Api(tags = "Резюме", description = "заполнение")
@RestController
@RequestMapping("/data")
public class PersonRestController {

    @Autowired
    private PersonRepository repository;


    @ApiOperation(value = "Записать")
    @PostMapping(value = "/person")
    public void savePerson(@RequestBody PersonDto person) {
        System.out.println("Sucsess");
        repository.save(person);
    }

    @ApiOperation(value = "Получить по id ")
    @GetMapping("/{id}")
    public List<PersonDto> getPerson(@PathVariable(value = "id") Long id) {
        return repository.findPersonById(id);
    }


    @ApiOperation(value = "Изменить")
    @PutMapping("/person")
    public void updatePerson(@RequestBody PersonDto person) {
        repository.save(person);
    }

    @ApiOperation(value = "Удалить по id")
    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable(value = "id") Long id) {
        repository.delete(repository.findPersonById(id).get(0));

    }

    @ApiOperation(value = "Список резюме с краткой информацией")
    @GetMapping(path = "/persons")
    public List<PersonDto> getPeople() {
//        List<PersonDto> list = this.repository.findAll();
//        List<ShortPerson> listShortPerson = new ArrayList<>();
//        for (PersonDto i:list) {
//            ShortPerson shortPerson = new ShortPerson();
//            shortPerson.setFio(i.getFio());
//            shortPerson.setTarget(i.getTarget());
//            listShortPerson.add(shortPerson);
//        }
        //return listShortPerson;
        return repository.findAll();
    }
}