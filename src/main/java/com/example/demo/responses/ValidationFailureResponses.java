package com.example.demo.responses;

import java.util.Collections;
import java.util.List;
import com.example.demo.enums.RestApiResponseStatus;
import com.example.demo.validation.ValidationFailure;


public class ValidationFailureResponses extends ApiResponses {
  public ValidationFailureResponses(List<ValidationFailure> validationErrors) {
    super(RestApiResponseStatus.VALIDATION_FAILURE);
    this.validationFailures = validationErrors;
  }

  public ValidationFailureResponses(String field, String code) {
    super(RestApiResponseStatus.VALIDATION_FAILURE);
    ValidationFailure validationFailure = new ValidationFailure(field, code);
    this.validationFailures = Collections.singletonList(validationFailure);
  }

  private List<ValidationFailure> validationFailures;

  public List<ValidationFailure> getValidationFailures() {
    return validationFailures;
  }

  public void setValidationFailures(List<ValidationFailure> validationFailures) {
    this.validationFailures = validationFailures;
  }

}

