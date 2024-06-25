package net.java.app.organizationservice.repository;

import java.util.Optional;
import net.java.app.organizationservice.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

  Optional<Organization> findByOrganizationCode(String organizationCode);
}
