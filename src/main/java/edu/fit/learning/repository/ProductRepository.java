package edu.fit.learning.repository;

import edu.fit.learning.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by virus on 03/14/16.
 */
public interface ProductRepository extends ElasticsearchRepository<Product, String> {

    Page<Product> findByTagsName(String name, Pageable pageable);
}
