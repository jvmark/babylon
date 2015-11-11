package com.onmysky.babylon.model.person.service;

import com.onmysky.babylon.model.person.domain.Person;

/**
 * Created by mark on 15/11/11.
 */
public interface IUserService {

    Person getById(int id);
}
