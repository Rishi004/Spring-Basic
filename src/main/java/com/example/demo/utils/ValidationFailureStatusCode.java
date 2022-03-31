package com.example.demo.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:ValidationMessages.properties")
public class ValidationFailureStatusCode {
  
  @Value("${validation.product.productNotExist}")
  private String productNotExist;
  @Value("${validation.product.idAlreadyExist}")
  private String idAlreadyExist;
  @Value("${validation.product.idNotExist}")
  private String idNotExist;
  @Value("${validation.product.nameNotExist}")
  private String nameNotExist;
  @Value("${validation.employee.leaveCountZero}")
  private String leaveCountZero;
  
  public String getLeaveCountZero() {
    return leaveCountZero;
  }
  public void setLeaveCountZero(String leaveCountZero) {
    this.leaveCountZero = leaveCountZero;
  }
  public String getProductNotExist() {
    return productNotExist;
  }
  public void setProductNotExist(String productNotExist) {
    this.productNotExist = productNotExist;
  }
  public String getIdAlreadyExist() {
    return idAlreadyExist;
  }
  public void setIdAlreadyExist(String idAlreadyExist) {
    this.idAlreadyExist = idAlreadyExist;
  }
  public String getIdNotExist() {
    return idNotExist;
  }
  public void setIdNotExist(String idNotExist) {
    this.idNotExist = idNotExist;
  }
  public String getNameNotExist() {
    return nameNotExist;
  }
  public void setNameNotExist(String nameNotExist) {
    this.nameNotExist = nameNotExist;
  }
  
  
}
