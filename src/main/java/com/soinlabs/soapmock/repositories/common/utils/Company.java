/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soinlabs.soapmock.repositories.common.utils;

/**
 *
 * @author Emanuel Urena
 */
public class Company {
    private String identification;
    private String name;
    private String legalStatus;

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setLegalStatus(String legalStatus) {
        this.legalStatus = legalStatus;
    }
    
    public String getLegalStatus() {
        return legalStatus;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
