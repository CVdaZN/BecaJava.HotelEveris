package br.hoteleveris.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.hoteleveris.app.request.ClienteRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController extends BaseController {

	@Autowired
	ClienteService _service;

	// Inserindo um Cliente com o verbo post
	@PostMapping
	public ResponseEntity<BaseResponse> criar(@RequestBody ClienteRequest request) {
		try {
			BaseResponse response = _service.criar(request);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	// Obtendo um Cliente com o verbo get 
	@GetMapping(path = "/{id}")
	public ResponseEntity<BaseResponse> obter(@PathVariable Long id) {
		try {
			BaseResponse response = _service.obter(id);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

}
