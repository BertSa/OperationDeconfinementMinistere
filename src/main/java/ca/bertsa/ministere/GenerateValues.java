package ca.bertsa.ministere;

import ca.bertsa.ministere.entities.Citizen;
import ca.bertsa.ministere.entities.Sex;
import ca.bertsa.ministere.entities.TypeLicense;
import ca.bertsa.ministere.repositories.CitizenRepository;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Component
public class GenerateValues implements CommandLineRunner {
    @Autowired
    private CitizenRepository repository;

    @Override
    public void run(String... args) {
        insert();
    }

    private void insert() {
        Faker faker = new Faker();
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-CA"), new RandomService());
        List<Citizen> list = new ArrayList<>();

        Citizen citizen;
        for (int i = 0; i < 100; i++) {
            citizen = new Citizen();
            citizen.setNoAssuranceMaladie(fakeValuesService.regexify("[A-Z]{4}[0-9]{8}"));
            citizen.setBirth(faker.date().birthday(0, 120).toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate());
            citizen.setFirstName(faker.name().firstName());
            citizen.setLastName(faker.name().lastName());
            citizen.setValid(faker.bool().bool());
            citizen.setSex(Sex.randomSex());
            citizen.setTypeValid(TypeLicense.randomType());
            list.add(citizen);
        }
        repository.saveAll(list);
    }
}
