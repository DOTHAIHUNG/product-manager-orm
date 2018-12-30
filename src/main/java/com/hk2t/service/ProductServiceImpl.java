package com.hk2t.service;

import com.hk2t.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map <Integer, Product> products;

    static {
        products = new HashMap <>();
        products.put(1, new Product(1, "Iphone X", 22000000, "Phien ban 64Gb chinh hang", "Apple"));
        products.put(2, new Product(2, "Samsung Galaxy Note 9", 17490000, "Ban chinh hang", "Samsung"));
        products.put(3, new Product(3, "Xiaomi Mi Mix 3", 12090000, "Ban chinh hang", "Xiaomi"));
        products.put(4, new Product(4, "ASUS ROG Phone", 19990000, "Ban chinh hang 128Gb", "ASUS"));
        products.put(5, new Product(5, "Samsung Galaxy S9+", 14590000, "Ban chinh hang", "Samsung"));
    }

    @Override
    public List <Product> findAll() {
        return new ArrayList <>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }
}
