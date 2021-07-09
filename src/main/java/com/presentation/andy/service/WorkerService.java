package com.presentation.andy.service;


import com.presentation.andy.model.Worker;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface WorkerService {
    List<Worker> findAll();

    boolean add(Map<String, String> params);

    boolean updateTasks(Map<String, String> params);

    boolean deleteById(Long id);

    boolean getResolution();

    List<Worker> SortByNameCollum(String sort);

    Optional<Worker> findById(Long id);

    boolean existsById(Long id);

    boolean isParamsValid(Map<String, String> params);

    boolean isAllParamsFound(Map<String, String> params);

    boolean getResolutionForAdd();

    boolean updateEmployer(Map<String, String> params);
}



