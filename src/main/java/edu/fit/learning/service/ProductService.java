package edu.fit.learning.service;

import edu.fit.learning.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * Created by virus on 03/14/16.
 */

public interface ProductService {

    Product save(Product product);

    Product findOne(String id);

    Iterable<Product> findAll();

    Page<Product> findByTagsName(String name, PageRequest pageRequest);

    void delete(String id);
}
