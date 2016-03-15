package edu.fit.learning.service.impl;

import edu.fit.learning.Application;
import edu.fit.learning.entities.Product;
import edu.fit.learning.entities.Tag;
import edu.fit.learning.service.ProductService;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

/**
 * Created by virus on 03/14/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductServiceImplTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImplTest.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    private Product product;

    @Before
    public void setUp() throws Exception {
        elasticsearchTemplate.deleteIndex(Product.class);
        elasticsearchTemplate.createIndex(Product.class);
        elasticsearchTemplate.putMapping(Product.class);
        elasticsearchTemplate.refresh(Product.class, true);
    }

    @After
    public void tearDown() throws Exception {
        elasticsearchTemplate.deleteIndex(Product.class);
    }

    @Test
    public void test1_testSave() throws Exception {
        product = new Product();
        product.setId("1");

        Tag tag = new Tag();
        tag.setName("Test");
        tag.setDescription("Test Description");
        tag.setPrice(10.00);

        List<Tag> tags = new ArrayList<Tag>();
        tags.add(tag);
        product.setTags(tags);

        productService.save(product);

        assertThat(product.getId(), notNullValue());
    }

    @Test
    public void test2_testFindOne() throws Exception {
        test1_testSave();
        LOGGER.debug(product.toString());
        assertEquals(product, productService.findOne("1"));
    }

    @Test
    public void test3_testFindAll() throws Exception {
        test1_testSave();
        Iterable<Product> products = productService.findAll();
        if(products.iterator().hasNext())
            assertEquals(true, true);
        else
            assertEquals(true, false);
    }

    @Test
    public void test4_testFindByTagsName() throws Exception {
        test1_testSave();
        Page<Product> productPages =  productService.findByTagsName("Test", new PageRequest(0,10));
        for(Product p: productPages) {
            LOGGER.info(p.toString());
            assertEquals(product, p);
        }

    }

}