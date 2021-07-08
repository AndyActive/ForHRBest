package com.presentation.andy.service;


import com.presentation.andy.model.Worker;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface WorkerService {
    List<Worker> findAll();

    Worker add(Map<String, String> params);

    boolean updatePlayer(Long id, Map<String, String> params);

    boolean deleteById(Long id);

    boolean getResolution();

    List<Worker> SortByNameCollum(String sort);

    //    List<Worker> findByParams(Map<String, String> params);
//    Integer countByParams(Map<String, String> params);
    Integer count();

    Worker findById(Long id);

    boolean existsById(Long id);

    boolean isIdValid(Long id);

    boolean isParamsValid(Map<String, String> params);

    boolean validParamsForUpdate(Map<String, String> params);

    boolean isAllParamsFound(Map<String, String> params);
}

