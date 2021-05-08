package ca.bertsa.ministere.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
public class Citizen implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String noAssuranceMaladie;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private LocalDate birth;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Sex sex;
    private boolean valid;
    @Enumerated(EnumType.STRING)
    private TypeLicense typeValid;

}

enum Sex {
    MALE, FEMALE, OTHER;

    @Override
    public String toString() {
        return super.name();
    }
}
