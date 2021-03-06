package me.dio.coding.votacao.bbb.api.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.dio.coding.votacao.bbb.api.model.ParameterModel;
import me.dio.coding.votacao.bbb.api.repository.ParameterRepository;

@RestController
@RequestMapping(value = "/api/parameters")
public class ParameterController {
	
	private final ParameterRepository repository;
	
	public ParameterController(ParameterRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<ParameterModel> save(@RequestBody ParameterModel parameter){
		ParameterModel entity = repository.save(parameter);
		return ResponseEntity.ok(entity);
	}
	
	@GetMapping(value = "/query")
	public ResponseEntity<ParameterModel> query(@RequestParam String key){
		Optional<ParameterModel> optParameter = repository.findById(key);
		if(optParameter.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(optParameter.get());
	}
	 
}
