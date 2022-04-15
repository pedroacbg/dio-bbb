package me.dio.coding.votacao.bbb.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("participants")
public class ParticipantModel {

	@Id
	private String id;
	private String name;
	
}
