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
public class GD_IngresaDocumentoRoute {
	@Bean(name = "constitution")
	public DefaultWsdl11Definition defaultWsdl11Definition(@Qualifier("constitutionxsd") XsdSchema legalStatusSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("SvtConstitucionService");
		wsdl11Definition.setLocationUri("/ws/constitution");
		//wsdl11Definition.setServiceName("SvtConstitucionPort"); //setea el service name, pero de todos modos no cambia el binding
		wsdl11Definition.setTargetNamespace("http://Constitucion.gobiernodigital/");
		wsdl11Definition.setSchema(legalStatusSchema);
		return wsdl11Definition;
	}

	@Bean(name = "constitutionxsd")
	public XsdSchema legalStatusSchema() {
		return new SimpleXsdSchema(new ClassPathResource("xsd/PS_RN_SvtConstitucionService.xsd"));
	}
}
