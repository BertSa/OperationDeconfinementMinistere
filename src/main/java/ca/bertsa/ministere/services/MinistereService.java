package ca.bertsa.ministere.services;

import ca.bertsa.ministere.entities.Citizen;
import ca.bertsa.ministere.entities.TypeLicense;
import ca.bertsa.ministere.repositories.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MinistereService {
    @Autowired
    CitizenRepository repository;

    public boolean checkCitizenValidity(String nassm, TypeLicense type) {
        System.out.println(nassm);
        boolean flag = false;
        try {
            if (repository.findByNoAssuranceMaladieIgnoreCaseAndTypeValidAndValid(nassm, type, true) != null) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public Citizen getCitizenInfo(String nassm) {
        return repository.findByNoAssuranceMaladieIgnoreCase(nassm);
    }

    public boolean checkCitizenExist(String nassm) {
        return repository.findByNoAssuranceMaladieIgnoreCase(nassm)!=null;
    }

    public TypeLicense getTypeValidity(String nassm) {
        return repository.findByNoAssuranceMaladieIgnoreCase(nassm).getTypeValid();
    }
}