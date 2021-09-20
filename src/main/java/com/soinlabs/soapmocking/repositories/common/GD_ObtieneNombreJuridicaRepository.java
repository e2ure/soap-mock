/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soinlabs.soapmocking.repositories.common;
import com.soinlabs.soapmocking.repositories.common.utils.Company;
import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 *
 * @author Emanuel Urena
 */
@Component
public class GD_ObtieneNombreJuridicaRepository {
    private static final Map<String, Company> companies = new HashMap<>();
    
    @PostConstruct
    public void initData() {
        Company company = new Company();
        company.setName("INDUSTRIAL VOLTERA SOCIEDAD ANONIMA");
        company.setIdentification("3101121212");

        companies.put("3101121212", company);

        company = new Company();
        company.setName("CONCEPTO ADUANAL SOCIEDAD ANONIMA");
        company.setIdentification("3101123131");

        companies.put("3101123131", company);

        company = new Company();
        company.setName("BANCO DAVIVIENDA COSTA RICA SOCIEDAD ANONIMA");
        company.setIdentification("3101046008");

        companies.put("3101046008", company);

        company = new Company();
        company.setName("INVERSIONES OM SHANTI SOCIEDAD ANONIMA");
        company.setIdentification("3101101086");

        companies.put("3101101086", company);
    }

    public Company findCompany(String identification) {
            Assert.notNull(identification, "The company's identifation must not be null");
            return companies.get(identification);
    }
}
