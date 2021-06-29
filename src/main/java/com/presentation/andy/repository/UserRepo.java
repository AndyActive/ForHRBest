package com.presentation.andy.repository;

import com.presentation.andy.model.Worker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepo extends CrudRepository<Worker,Long> {
}
