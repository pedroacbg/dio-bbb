package me.dio.coding.votacao.bbb.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import me.dio.coding.votacao.bbb.api.model.ParticipantModel;
import me.dio.coding.votacao.bbb.api.service.VoteService;

@RestController
@RequestMapping(value = "/api/vote")
@AllArgsConstructor
public class VoteController {

	private final VoteService service;
	
	@PostMapping
	public ResponseEntity<String> vote(@RequestBody ParticipantModel participant){
		service.addEvent(participant);
		return ResponseEntity.ok("Voto Computado!");
	}
	
}
