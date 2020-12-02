package com.elmelund.jpademo.repositories;

import com.elmelund.jpademo.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
