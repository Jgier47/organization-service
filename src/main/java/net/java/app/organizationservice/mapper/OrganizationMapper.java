package net.java.app.organizationservice.mapper;

import net.java.app.organizationservice.dto.OrganizationDto;
import net.java.app.organizationservice.entity.Organization;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {

  OrganizationDto mapToOrganizationDto(Organization organization);

  Organization mapToOrganization(OrganizationDto organizationDto);
}
