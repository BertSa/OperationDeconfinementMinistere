package ca.bertsa.ministere.repositories;

import ca.bertsa.ministere.entities.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {

    Citizen findByNoAssuranceMaladieIgnoreCaseAndTypeValidIgnoreCaseAndValid(String noAssuranceMaladie, String type, boolean b);

    Citizen findByNoAssuranceMaladieIgnoreCase(String nassm);
}
