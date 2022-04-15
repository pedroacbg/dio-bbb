package me.dio.coding.votacao.bbb.api.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import me.dio.coding.votacao.bbb.api.model.ParticipantModel;

@Service
@AllArgsConstructor
public class VoteService {

	private static final String TOPIC_VOTE = "voting";
	
	private final KafkaTemplate<Object, Object> template;
	
	public void addEvent(ParticipantModel participant) {
		template.send(TOPIC_VOTE, participant);
	}
}
