package carservice.repository;


import carservice.model.autopartsection.AutoPartsSection;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoPartsSectionRepository extends JpaRepository<AutoPartsSection, Long> {
}
