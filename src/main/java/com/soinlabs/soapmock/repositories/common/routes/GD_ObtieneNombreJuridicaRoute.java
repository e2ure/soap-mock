package com.soinlabs.soapmock.repositories.common.routes;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class GD_ObtieneNombreJuridicaRoute {
	@Bean(name = "companies")
	public DefaultWsdl11Definition defaultWsdl11Definition(@Qualifier("companiesxsd") XsdSchema companiesSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("GD_ObtieneNombreJuridica");
		wsdl11Definition.setLocationUri("/ws/getname");
		//wsdl11Definition.setServiceName("gd_obtienenombrejuridica_client_ep"); //setea el service name, pero de todos modos no cambia el binding
		wsdl11Definition.setTargetNamespace("http://xmlns.oracle.com/Application1/GD_ObtieneNombreJuridica/GD_ObtieneNombreJuridica");
		wsdl11Definition.setSchema(companiesSchema);
		return wsdl11Definition;
	}

	@Bean(name="companiesxsd")
	public XsdSchema companySchema() {
		return new SimpleXsdSchema(new ClassPathResource("xsd/GD_ObtieneNombreJuridica.xsd"));
	}
}

