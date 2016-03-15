package edu.fit.learning.service.impl;

import edu.fit.learning.entities.Product;
import edu.fit.learning.repository.ProductRepository;
import edu.fit.learning.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * Created by virus on 03/14/16.
 */

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findOne(String id) {
        return productRepository.findOne(id);
    }

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> findByTagsName(String name, PageRequest pageRequest) {
        return productRepository.findByTagsName(name, pageRequest);
    }

    @Override
    public void delete(String id) {
        productRepository.delete(id);
    }
}
