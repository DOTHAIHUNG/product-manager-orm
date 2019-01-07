package com.hk2t.service;

import com.hk2t.model.Product;
import com.hk2t.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
//    private static Map <Integer, Product> products;
//
//    static {
//        products = new HashMap <>();
//        products.put(1, new Product((long) 1, "Iphone X", 22000000, "Phien ban 64Gb chinh hang", "Apple"));
//        products.put(2, new Product((long) 2, "Samsung Galaxy Note 9", 17490000, "Ban chinh hang", "Samsung"));
//        products.put(3, new Product((long) 3, "Xiaomi Mi Mix 3", 12090000, "Ban chinh hang", "Xiaomi"));
//        products.put(4, new Product((long) 4, "ASUS ROG Phone", 19990000, "Ban chinh hang 128Gb", "ASUS"));
//        products.put(5, new Product((long) 5, "Samsung Galaxy S9+", 14590000, "Ban chinh hang", "Samsung"));
//    }

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List <Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.remove(id);
    }
}
