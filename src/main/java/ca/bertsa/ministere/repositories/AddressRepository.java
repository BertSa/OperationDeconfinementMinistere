package ca.bertsa.ministere.repositories;

import ca.bertsa.ministere.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findAddressByZipCodeIgnoreCaseAndStreetIgnoreCaseAndCityIgnoreCaseAndProvinceIgnoreCaseAndApt(String zipCode, String street, String city, String province, String apt);
}