package net.java.app.organizationservice.service.impl;

import java.util.Optional;
import lombok.AllArgsConstructor;
import net.java.app.organizationservice.dto.OrganizationDto;
import net.java.app.organizationservice.entity.Organization;
import net.java.app.organizationservice.exceptions.OrganizationAlreadyExistsException;
import net.java.app.organizationservice.exceptions.ResourceNotFoundException;
import net.java.app.organizationservice.mapper.OrganizationMapper;
import net.java.app.organizationservice.repository.OrganizationRepository;
import net.java.app.organizationservice.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

  @Autowired OrganizationRepository organizationRepository;
  @Autowired OrganizationMapper organizationMapper;

  @Override
  public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
    checkIfOrganizationAlreadyExists(organizationDto);

    Organization savedOrganization =
        organizationRepository.save(organizationMapper.mapToOrganization(organizationDto));
    return organizationMapper.mapToOrganizationDto(savedOrganization);
  }

  @Override
  public OrganizationDto getOrganizationByCode(String organizationCode) {
    Organization organizationFromDb =
        organizationRepository
            .findByOrganizationCode(organizationCode)
            .orElseThrow(
                () ->
                    new ResourceNotFoundException(
                        "Organization", "organizationCode", organizationCode));

    return organizationMapper.mapToOrganizationDto(organizationFromDb);
  }

  private void checkIfOrganizationAlreadyExists(OrganizationDto organizationDto) {
    Optional<Organization> organization =
        organizationRepository.findByOrganizationCode(organizationDto.getOrganizationCode());
    if (organization.isPresent())
      throw new OrganizationAlreadyExistsException(
          String.format(
              "Organization with email %s already exists", organizationDto.getOrganizationCode()));
  }
}
