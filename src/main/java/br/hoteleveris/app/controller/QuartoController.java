package br.hoteleveris.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import br.hoteleveris.app.request.QuartoRequest;
import br.hoteleveris.app.request.SituacaoQuartoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.service.QuartoService;

@RestController
@RequestMapping("/quartos")
public class QuartoController extends BaseController {

	@Autowired
	QuartoService _service;

//	 Atualizar situação do quarto (utilizar o verbo PATCH do Rest)
	@PatchMapping("/{id}")
	public ResponseEntity<BaseResponse> atualizar(@Validated @PathVariable("id") Long id,
			@RequestBody SituacaoQuartoRequest request) {

		try {
			BaseResponse response = _service.atualizar(id, request);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {

			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}

	}

	// Obtendo um quarto atraves o verbo get
	@GetMapping(path = "/{id}")
	public ResponseEntity<BaseResponse> obter(@PathVariable Long id) {
		try {
			BaseResponse response = _service.obter(id);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	// Obtendo id em forma de lista
	@GetMapping(path = "/tipo/{id}")
	public ResponseEntity<BaseResponse> listar(@PathVariable Long id) {
		try {
			BaseResponse response = _service.listar(id);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	// Inserindo um quarto com verbo post
	@PostMapping
	public ResponseEntity<BaseResponse> criar(@RequestBody QuartoRequest request) {
		try {
			BaseResponse response = _service.criar(request);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}

	}
}