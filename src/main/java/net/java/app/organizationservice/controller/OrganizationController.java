package net.java.app.organizationservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.java.app.organizationservice.dto.OrganizationDto;
import net.java.app.organizationservice.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
    name = "Organization Service - Organization Controller",
    description = "Organization Controller exposes REST APIs for Organization Service")
@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {

  @Autowired OrganizationService organizationService;

  @Operation(
      summary = "Save Organization REST API",
      description = "Save Organization REST API is used to save organization object in a database")
  @ApiResponse(responseCode = "201", description = "HTTP Status 201 Created")
  @PostMapping()
  public ResponseEntity<OrganizationDto> saveOrganization(
      @RequestBody OrganizationDto organizationDto) {
    return new ResponseEntity<>(
        organizationService.saveOrganization(organizationDto), HttpStatus.CREATED);
  }

  @Operation(
      summary = "Get Organization REST API",
      description =
          "Get Organization REST API is used to get Organization object from the database")
  @ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")
  @GetMapping("{organizationCode}")
  public ResponseEntity<OrganizationDto> getOrganizationByCode(
      @PathVariable("organizationCode") String organizationCode) {
    return new ResponseEntity<>(
        organizationService.getOrganizationByCode(organizationCode), HttpStatus.OK);
  }
}
