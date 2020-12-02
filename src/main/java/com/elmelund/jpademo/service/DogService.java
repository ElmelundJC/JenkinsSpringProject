package com.elmelund.jpademo.service;

import com.elmelund.jpademo.model.Dog;

import java.util.List;

public interface DogService extends CrudService<Dog,Long>{
    public List<Dog> getOwnerlessDogs();
    public List<Dog> getDogs(int start, int number);
}
