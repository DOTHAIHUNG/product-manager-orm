package com.hk2t.service;

import com.hk2t.model.Product;

import java.util.List;

public interface ProductService {
    List <Product> findAll();

    void save(Product product);

    void remove(Long id);

    Product findById(Long id);
}
