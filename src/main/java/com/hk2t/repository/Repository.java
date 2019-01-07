package com.hk2t.repository;

import java.util.List;

public interface Repository<T> {
    List <T> findAll();

    void save(T model);

    T findById(Long id);

    void remove(Long id);
}
