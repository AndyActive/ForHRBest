package com.presentation.andy.repository;

import com.presentation.andy.model.Worker;
import com.presentation.andy.projects.Projects;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepoIMPL implements UserRepo{

    @Override
    public Page<Worker> findAllByParams(String name, Integer salary, String completedTasks, String outstandingTasks, Projects workProjects, Boolean online) {
        return null;
    }

    @Override
    public Page<Worker> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public int countByParams(String name, Integer salary, String completedTasks, String outstandingTasks, Projects workProjects, Boolean online) {
        return 0;
    }

    @Override
    public List<Worker> findAll() {
        return null;
    }

    @Override
    public List<Worker> findAll(Sort sort) {
        return null;
    }

    @Override
    public List<Worker> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Worker worker) {

    }

    @Override
    public void deleteAll(Iterable<? extends Worker> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Worker> S save(S s) {
        return null;
    }

    @Override
    public <S extends Worker> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Worker> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Worker> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public <S extends Worker> List<S> saveAllAndFlush(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Worker> iterable) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Worker getOne(Long aLong) {
        return null;
    }

    @Override
    public Worker getById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Worker> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Worker> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Worker> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Worker> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Worker> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Worker> boolean exists(Example<S> example) {
        return false;
    }
}
