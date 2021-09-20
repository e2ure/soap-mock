/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soinlabs.soapmocking.repositories.common.routes;

import com.oracle.xmlns.application1.gd_obtienenombrejuridica.gd_obtienenombrejuridica.ProcessRequest;
import com.oracle.xmlns.application1.gd_obtienenombrejuridica.gd_obtienenombrejuridica.ProcessResponse;
import com.soinlabs.soapmocking.repositories.common.GD_ObtieneNombreJuridicaRepository;
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
public class GD_ObtieneNombreJuridicaController {
    private static final String NAMESPACE_URI = "http://xmlns.oracle.com/Application1/GD_ObtieneNombreJuridica/GD_ObtieneNombreJuridica";

	private GD_ObtieneNombreJuridicaRepository gdObtieneNombreJuridicaRepository;

	@Autowired
	public GD_ObtieneNombreJuridicaController(GD_ObtieneNombreJuridicaRepository repository) {
		this.gdObtieneNombreJuridicaRepository = repository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "processRequest")
	@ResponsePayload
	public ProcessResponse getCountry(@RequestPayload ProcessRequest request) {
		ProcessResponse response = new ProcessResponse();
		response.setNombreSociedad(gdObtieneNombreJuridicaRepository.findCompany(request.getCedulaJuridica()).getName());
		response.setResultado("0");
		response.setError("");
		return response;
	}
}
