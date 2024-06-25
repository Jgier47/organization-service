package net.java.app.organizationservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OrganizationAlreadyExistsException extends RuntimeException {
  public OrganizationAlreadyExistsException(String message) {
    super(message);
  }
}
