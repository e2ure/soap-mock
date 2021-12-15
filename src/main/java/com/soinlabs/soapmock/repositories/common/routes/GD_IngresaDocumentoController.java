package com.soinlabs.soapmock.repositories.common.routes;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

//import com.soinlabs.soapmock.repositories.common.GD_ObtieneNombreJuridicaRepository;

import gobiernodigital.constitucion.IngresaDocumento;
import gobiernodigital.constitucion.IngresaDocumentoResponse;
import gobiernodigital.constitucion.IngresarDocumentoDefectuoso;
import gobiernodigital.constitucion.IngresarDocumentoDefectuosoResponse;

/**
 *
 * @author Emanuel Urena
 */
@Endpoint
public class GD_IngresaDocumentoController {
	private static final String NAMESPACE_URI = "http://Constitucion.gobiernodigital/";

	//private GD_ObtieneNombreJuridicaRepository gdObtieneNombreJuridicaRepository;

	@Autowired
	public GD_IngresaDocumentoController() {
		//this.gdObtieneNombreJuridicaRepository = repository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "IngresaDocumento")
	@ResponsePayload
	public JAXBElement<IngresaDocumentoResponse> setDocumentInfo(@RequestPayload JAXBElement<IngresaDocumento> request) {
		
		IngresaDocumentoResponse response = new IngresaDocumentoResponse();
		response.setReturn("<DocumentoProcesado>\r\n"
				+ "	<Errores>\r\n"
				+ "		<Error>\r\n"
				+ "			<Codigo_Error>65</Codigo_Error>\r\n"
				+ "			<Descripcion_Error>Error, fuera del horario de atención</Descripcion_Error>\r\n"
				+ "			<Tipo_Error>Tecnico</Tipo_Error>\r\n"
				+ "			<Identificacion_GUI>57634FE9-4AA7-4C4A-AA09-FF050533976B</Identificacion_GUI>\r\n"
				+ "		</Error>\r\n"
				+ "	</Errores>\r\n"
				+ "</DocumentoProcesado>");
		
		
		return createJaxbElement(response,IngresaDocumentoResponse.class);
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "IngresarDocumentoDefectuoso")
	@ResponsePayload
	public JAXBElement<IngresarDocumentoDefectuosoResponse> setDocumentInfoWarned(@RequestPayload JAXBElement<IngresarDocumentoDefectuoso> request) {
		IngresarDocumentoDefectuosoResponse response = new IngresarDocumentoDefectuosoResponse();
		response.setReturn("<DocumentoProcesado>\r\n"
				+ "	<Errores>\r\n"
				+ "		<Error>\r\n"
				+ "			<Codigo_Error>65</Codigo_Error>\r\n"
				+ "			<Descripcion_Error>Error, fuera del horario de atención</Descripcion_Error>\r\n"
				+ "			<Tipo_Error>Tecnico</Tipo_Error>\r\n"
				+ "			<Identificacion_GUI>57634FE9-4AA7-4C4A-AA09-FF050533976B</Identificacion_GUI>\r\n"
				+ "		</Error>\r\n"
				+ "	</Errores>\r\n"
				+ "</DocumentoProcesado>");
		return createJaxbElement(response,IngresarDocumentoDefectuosoResponse.class);
	}
	
	private <T> JAXBElement<T> createJaxbElement(T object, Class<T> clazz) {
	    return new JAXBElement<>(new QName(clazz.getSimpleName()), clazz, object);
	  }
}
