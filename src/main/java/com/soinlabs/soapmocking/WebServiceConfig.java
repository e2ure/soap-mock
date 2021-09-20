package com.soinlabs.soapmocking;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;


@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(servlet, "/ws/*");
	}

	@Bean(name = "companies")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema companiesSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("GD_ObtieneNombreJuridica");
		wsdl11Definition.setLocationUri("/ws");
		//wsdl11Definition.setServiceName("gd_obtienenombrejuridica_client_ep"); //setea el service name, pero de todos modos no cambia el binding
		wsdl11Definition.setTargetNamespace("http://xmlns.oracle.com/Application1/GD_ObtieneNombreJuridica/GD_ObtieneNombreJuridica");
		wsdl11Definition.setSchema(companiesSchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema companySchema() {
		return new SimpleXsdSchema(new ClassPathResource("xsd/GD_ObtieneNombreJuridica.xsd"));
	}
}