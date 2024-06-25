package net.java.app.organizationservice.service;

import net.java.app.organizationservice.dto.OrganizationDto;

public interface OrganizationService {
  OrganizationDto saveOrganization(OrganizationDto organizationDto);

  OrganizationDto getOrganizationByCode(String organizationCode);
}
