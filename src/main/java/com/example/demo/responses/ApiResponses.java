package com.example.demo.responses;

import com.example.demo.enums.RestApiResponseStatus;

public class ApiResponses {
  private String status;
  private int statusCode;
  
  public ApiResponses(RestApiResponseStatus restApiResponseStatus) {
    this.status = restApiResponseStatus.getStatus();
    this.statusCode = restApiResponseStatus.getCode();
  }
  
  public static final ApiResponses OK = new ApiResponses(RestApiResponseStatus.OK);
  
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }
  public int getStatusCode() {
    return statusCode;
  }
  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }
  
  
}
