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
public class GD_ObtienePersoneriaRoute {
	@Bean(name = "companieslegalstatus")
	public DefaultWsdl11Definition defaultWsdl11Definition(@Qualifier("companieslegalstatusxsd") XsdSchema legalStatusSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("GD_ObtienePersoneria");
		wsdl11Definition.setLocationUri("/ws/getlegalstatus");
		//wsdl11Definition.setServiceName("gd_obtienenombrejuridica_client_ep"); //setea el service name, pero de todos modos no cambia el binding
		wsdl11Definition.setTargetNamespace("http://xmlns.oracle.com/GobiernoDigital/GD_ObtienePersoneria/GD_ObtienePersoneria");
		wsdl11Definition.setSchema(legalStatusSchema);
		return wsdl11Definition;
	}

	@Bean(name = "companieslegalstatusxsd")
	public XsdSchema legalStatusSchema() {
		return new SimpleXsdSchema(new ClassPathResource("xsd/GD_ObtienePersoneria.xsd"));
	}
}

