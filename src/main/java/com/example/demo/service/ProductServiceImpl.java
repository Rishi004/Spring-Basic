package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductRepository productRepository;

  public Product saveProduct(Product product) {
    return productRepository.save(product);
  }

  public List<Product> saveProducts(List<Product> products) {
    return productRepository.saveAll(products);
  }

  public List<Product> getProducts() {
    return productRepository.findAll();
  }

  public Product getProductById(int id) {
    return productRepository.findById(id).orElse(null);
  }

  public List<Product> getProductByName(String name) {
    return productRepository.findByName(name);
  }

  public String deleteProduct(int id) {
    productRepository.deleteById(id);
    return "Product removed !! " + id;
  }

  public Product updateProduct(Product product) {
    Product existingProduct = productRepository.findById(product.getId()).orElse(null);
    existingProduct.setName(product.getName());
    existingProduct.setQuantity(product.getQuantity());
    existingProduct.setPrice(product.getPrice());
    return productRepository.save(existingProduct);
  }

  @Override
  public boolean isProductIdExists(int id) {
    return productRepository.existsById(id);
  }


}
