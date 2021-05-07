package ca.bertsa.ministere.controllers;

import ca.bertsa.ministere.entities.Citizen;
import ca.bertsa.ministere.services.MinistereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static ca.bertsa.ministere.entities.TypeLicense.NegativeTest;
import static ca.bertsa.ministere.entities.TypeLicense.Vaccine;

@RestController
@RequestMapping("/ministere")
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
public class MinistereController {

    @Autowired
    MinistereService service;


    @GetMapping("/info/{nassm}")
    public Citizen getBasicInformationForNegativeTest(@PathVariable String nassm) {
        return service.getCitizenInfo(nassm);
    }

    @GetMapping("/validate/vaccine/{nassm}")
    public boolean checkCitizenValidityForVaccine(@PathVariable String nassm) {
        return service.checkCitizenValidity(nassm, Vaccine);
    }

    @GetMapping("/validate/negativetest/{nassm}")
    public boolean checkCitizenValidityForNegative(@PathVariable String nassm) {
        return service.checkCitizenValidity(nassm, NegativeTest);
    }

    @GetMapping("/exist/{nassm}")
    public boolean nassmExist(@PathVariable String nassm) {
        return service.checkCitizenExist(nassm);
    }

}
