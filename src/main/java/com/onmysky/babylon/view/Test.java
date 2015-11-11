package com.onmysky.babylon.view;

import com.onmysky.babylon.model.person.domain.Person;
import com.onmysky.babylon.model.person.repository.PersonRepository;
import com.onmysky.babylon.model.person.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by mark on 15/11/6.
 */
@RestController
public class Test {

    private IUserService userService;

    @Resource
    PersonRepository repository;

    @RequestMapping(value = "/")
    public Person getTest() {
        return repository.findById(2);
    }

    @RequestMapping(value = "/mark")
    public int save() {
        Person person = new Person();
        person.setName("123123");
        person.setId(2);
        return repository.save(person);
    }
}
