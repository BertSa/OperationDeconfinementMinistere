package ca.bertsa.ministere.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String zipCode;
    private String street;
    private String city;
    private String province;
    private String apt;


    /**
     * @param zipCode  Postal code
     * @param apt      Appartement number (When applicable)
     * @param street   Street name
     * @param city     City
     * @param province Province
     */
    public Address(@NonNull String zipCode, @NonNull String street, @NonNull String city, @NonNull String province, String apt) {
        this.zipCode = zipCode;
        this.apt = apt;
        this.street = street;
        this.city = city;
        this.province = province;
    }
}
