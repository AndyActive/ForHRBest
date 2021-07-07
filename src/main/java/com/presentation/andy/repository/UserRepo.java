package com.presentation.andy.repository;

import com.presentation.andy.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Worker, Long> {

    Optional<Worker> findByEmail(String email);

}


