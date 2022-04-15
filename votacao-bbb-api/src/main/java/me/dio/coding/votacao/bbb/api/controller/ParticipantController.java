package me.dio.coding.votacao.bbb.api.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import me.dio.coding.votacao.bbb.api.model.ParticipantModel;
import me.dio.coding.votacao.bbb.api.repository.ParticipantRepository;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/participants")
public class ParticipantController {
	
	private final ParticipantRepository repository;
	
	@PostMapping(value = "/save")
	public ResponseEntity<ParticipantModel> save(@RequestBody ParticipantModel participant){
		ParticipantModel entity = repository.save(participant);
		return ResponseEntity.ok(entity);
	}
	
	@GetMapping(value = "/query")
	public ResponseEntity<ParticipantModel> query(@RequestParam String id){
		Optional<ParticipantModel> optParticipant = repository.findById(id);
		if(optParticipant.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(optParticipant.get());
	}
	 
}
