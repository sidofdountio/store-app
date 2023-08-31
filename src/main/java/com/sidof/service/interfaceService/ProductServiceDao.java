package com.sidof.service.interfaceService;

import com.sidof.model.Product;

import java.util.List;

/**
 * @Author sidof
 * @Since 03/08/2023
 * @Version v1.0
 */
public interface ProductServiceDao {
    Product addProduct(Product product);
    Product updateProduct(Product product);
    Product getProductById(Long ProductId);
    void deleteProduct(Long productToDelete);
    List<Product>getProducts();
}
