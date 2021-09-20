/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soinlabs.soapmock.repositories.common.routes;

import com.oracle.xmlns.gobiernodigital.gd_obtienepersoneria.gd_obtienepersoneria.ProcessRequest;
import com.oracle.xmlns.gobiernodigital.gd_obtienepersoneria.gd_obtienepersoneria.ProcessResponse;
import com.soinlabs.soapmock.repositories.common.GD_ObtieneNombreJuridicaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 *
 * @author Emanuel Urena
 */
@Endpoint
public class GD_ObtienePersoneriaController {
    private static final String NAMESPACE_URI = "http://xmlns.oracle.com/GobiernoDigital/GD_ObtienePersoneria/GD_ObtienePersoneria";

	private GD_ObtieneNombreJuridicaRepository gdObtieneNombreJuridicaRepository;

	@Autowired
	public GD_ObtienePersoneriaController(GD_ObtieneNombreJuridicaRepository repository) {
		this.gdObtieneNombreJuridicaRepository = repository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "processRequest")
	@ResponsePayload
	public ProcessResponse getCountry(@RequestPayload ProcessRequest request) {
		ProcessResponse response = new ProcessResponse();
		response.setXMLPersoneria(gdObtieneNombreJuridicaRepository.findCompany(request.getCedulaJuridica()).getLegalStatus());
		response.setResultado("0");
		response.setError("");
		return response;
	}
}
