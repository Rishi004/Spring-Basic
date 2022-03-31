package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Product;

public interface ProductService {
  public Product saveProduct(Product product);

  public List<Product> saveProducts(List<Product> products);

  public List<Product> getProducts();

  public Product getProductById(int id);

  public List<Product> getProductByName(String name);

  public String deleteProduct(int id);

  public Product updateProduct(Product product);
  
  public boolean isProductIdExists (int id);
  
}
