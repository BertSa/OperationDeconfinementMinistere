package ca.bertsa.ministere.repositories;

import ca.bertsa.ministere.entities.Citizen;
import ca.bertsa.ministere.entities.TypeLicense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {

    Citizen findByNoAssuranceMaladieIgnoreCaseAndTypeValidAndValid(String noAssuranceMaladie, TypeLicense type, boolean valid);

    Citizen findByNoAssuranceMaladieIgnoreCase(String nassm);

    TypeLicense findByNoAssuranceMaladieIgnoreCaseAndValid(String nassm, boolean b);
}
