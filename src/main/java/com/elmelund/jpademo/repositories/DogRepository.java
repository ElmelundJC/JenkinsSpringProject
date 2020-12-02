package com.elmelund.jpademo.repositories;

import com.elmelund.jpademo.model.Dog;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DogRepository extends PagingAndSortingRepository<Dog,Long> {

}
