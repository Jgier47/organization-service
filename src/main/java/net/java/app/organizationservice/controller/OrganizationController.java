package net.java.app.organizationservice.controller;

import lombok.AllArgsConstructor;
import net.java.app.organizationservice.dto.OrganizationDto;
import net.java.app.organizationservice.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {

  @Autowired OrganizationService organizationService;

  @PostMapping()
  public ResponseEntity<OrganizationDto> saveOrganization(
      @RequestBody OrganizationDto organizationDto) {
    return new ResponseEntity<>(
        organizationService.saveOrganization(organizationDto), HttpStatus.CREATED);
  }

  @GetMapping("{organizationCode}")
  public ResponseEntity<OrganizationDto> getOrganizationByCode(
      @PathVariable("organizationCode") String organizationCode) {
    return new ResponseEntity<>(
        organizationService.getOrganizationByCode(organizationCode), HttpStatus.OK);
  }
}
