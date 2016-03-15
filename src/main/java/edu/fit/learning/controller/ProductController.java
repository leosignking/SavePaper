package edu.fit.learning.controller;

import edu.fit.learning.entities.Product;
import edu.fit.learning.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by virus on 03/14/16.
 */

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> findProducts() {
        return (List<Product>) productService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Product addProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    /*@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product updateProduct(@RequestBody Product updatedProduct, @PathVariable Long id){
        return productService.save(updatedProduct);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public void deleteProduct(@PathVariable Long id) {
        productService.delete(id);
    }*/

}
