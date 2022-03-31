package com.example.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProductDto {
  
  @NotNull(message = "{product.id.null}")
  @NotEmpty(message = "{product.id.empty}")
  @NotBlank(message = "{product.id.blank}")
  private int id;
  @NotNull(message = "{product.name.null}")
  @NotEmpty(message = "{product.name.empty}")
  @NotBlank(message = "{product.name.blank}")
  private String name;
  private int quantity;
  private double price;
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getQuantity() {
    return quantity;
  }
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
  public double getPrice() {
    return price;
  }
  public void setPrice(double price) {
    this.price = price;
  }

}
