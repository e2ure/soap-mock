/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soinlabs.soapmock.repositories.common;
import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.soinlabs.soapmock.repositories.common.utils.Company;

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
        company.setLegalStatus("<return>\r\n"
        		+ "<CITAS_ANTECEDENTE>TOMO:0682 FOLIO:290 ASIENTO:00355</CITAS_ANTECEDENTE>\r\n"
        		+ "<DOCUMENTO_ORIGEN> TOMO:389 ASIENTO:17084 FECHA INSCRIPCION:25/08/2009</DOCUMENTO_ORIGEN>\r\n"
        		+ "<DOMICILIO>PROVINCIA 01 SAN JOSE, CANTON 14 MORAVIA, 250 METROS AL SUR DEL PARQUEO LA CLINICA CATOLICA, SAN ANTONIO DE GUADALUPE.</DOMICILIO>\r\n"
        		+ "<ESTADO_ACTUAL>DISUELTA POR LEY 9024</ESTADO_ACTUAL>\r\n"
        		+ "<ESTADO_LEY9428>NO MOROSA</ESTADO_LEY9428>\r\n"
        		+ "<FACULTADES>LA JUNTA DIRECTIVA NO TIENE FACULTAD PARA OTORGAR PODERES</FACULTADES>\r\n"
        		+ "<OBJETO_FINES_SINTESIS>SERVICIO EN TRAMITE DE DESALMACENAJE, CARGAS PROVENIENTES DEL EXTERIOR, REPRESENTANCION DE LINEAS NAVIERAS, RECEPCION DE BARCOS, EN TODOS LOS PUERTOS DEL PAIS, COMERCIO, INDUSTRIA, POSEER Y DISPONER DE BIENES MUEBLES E INMUEBLES.</OBJETO_FINES_SINTESIS>\r\n"
        		+ "<PERSONA_JURIDICA>3-101-123131</PERSONA_JURIDICA>\r\n"
        		+ "<PLAZO_DIRECTORES_PRORROGAS>LA JUNTA DIRECTIVA Y FISCAL SERAN NOMBRADOS POR TODO EL PLAZO SOCIAL. HABRA UN AGENTE RESIDENTE.</PLAZO_DIRECTORES_PRORROGAS>\r\n"
        		+ "<PLAZO_ENTIDAD_JURIDICA>INICIO: 18/09/1991 VENCIMIENTO: 18/09/2090</PLAZO_ENTIDAD_JURIDICA>\r\n"
        		+ "<RAZON_SOCIAL>CONCEPTO ADUANAL SOCIEDAD ANONIMA</RAZON_SOCIAL>\r\n"
        		+ "<REPRESENTACION>CORRESPONDE AL PRESIDENTE, LA REPRESENTACION JUDICIAL Y EXTRAJUDICIAL DE LA SOCIEDAD CON FACULTADES DE APODERADO GENERALISIMO SIN LIMITE DE SUMA, PUDIENDO SUSTITUIR SU PODER EN TODO O EN PARTE, REVOCAR SUSTITUCIONES Y HACER OTRAS DE NUEVO, RESERVANDOSE O NO SU PODER.</REPRESENTACION>\r\n"
        		+ "</return>");

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
