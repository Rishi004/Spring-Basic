package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.ProductDto;
import com.example.demo.dto.ProductResponceDto;
import com.example.demo.entity.Product;
import com.example.demo.enums.RestApiResponseStatus;
import com.example.demo.mapper.Mapper;
import com.example.demo.responses.ContentResponse;
import com.example.demo.responses.ValidationFailureResponses;
import com.example.demo.service.ProductService;
import com.example.demo.utils.Msg;
import com.example.demo.utils.ValidationFailureStatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class ProductController {

  @Autowired
  private ProductService productService;

  @Autowired
  private Mapper mapper;

  @Autowired
  private ValidationFailureStatusCode validationFailureStatusCode;

  private static final Logger logger = LoggerFactory.getLogger(ProductController.class);


  @PostMapping("/rest/addProduct")
  public ResponseEntity<Object> addProduct(@RequestBody ProductDto productDto) {
    productService.saveProduct(mapper.map(productDto, Product.class));
    return new ResponseEntity<>(Msg.PRODUCT_ADD_SUCCESS, HttpStatus.OK);
  }

  @GetMapping("/rest/products")
  public ResponseEntity<Object> findAllProducts() {
    return new ResponseEntity<Object>(mapper.map(productService.getProducts(), ProductDto.class),
        HttpStatus.OK);
  }

  @GetMapping("/rest/nameandprice")
  public ResponseEntity<Object> getNameAndPrice() {
    return new ResponseEntity<Object>(
        mapper.map(productService.getProducts(), ProductResponceDto.class), HttpStatus.OK);
  }

  @GetMapping("/rest/productById/{id}")
  public ResponseEntity<Object> findProductById(@PathVariable int id) {
    if (productService.isProductIdExists(id)) {
      logger.info("Get Product By Id success");
      return new ResponseEntity<>(new ContentResponse<>(Msg.PRODUCT,
          mapper.map(productService.getProductById(id), ProductResponceDto.class),
          RestApiResponseStatus.OK), HttpStatus.OK);
    }
    logger.info("Product Id {} not found", id);
    return new ResponseEntity<>(
        new ValidationFailureResponses(Msg.ID, validationFailureStatusCode.getProductNotExist()),
        HttpStatus.BAD_REQUEST);
  }

  @GetMapping("/rest/productByName/{name}")
  public ResponseEntity<Object> findProductByName(@PathVariable String name) {
    return new ResponseEntity<Object>(
        mapper.map(productService.getProductByName(name), ProductResponceDto.class), HttpStatus.OK);

  }

  @PutMapping("/rest/update")
  public ResponseEntity<Object> updateProduct(@RequestBody ProductDto productDto) {
    productService.updateProduct(mapper.map(productDto, Product.class));
    return new ResponseEntity<>(Msg.PRODUCT_UPDATE_SUCCESS, HttpStatus.OK);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Object> deleteProduct(@PathVariable int id) {
    productService.deleteProduct(id);
    return new ResponseEntity<Object>(Msg.PRODUCT_DELETE_SUCCESS, HttpStatus.OK);
  }
}
