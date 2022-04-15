package me.dio.coding.votacao.bbb.ms.service;

import java.util.Date;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.dio.coding.votacao.bbb.ms.model.ParticipantModel;
import me.dio.coding.votacao.bbb.ms.model.VoteModel;
import me.dio.coding.votacao.bbb.ms.repository.VoteRepository;

@Service
@Slf4j
@AllArgsConstructor
public class VoteService {

    private final VoteRepository repository;

    @KafkaListener(topics = "voting", groupId = "MicroServicoVote")
    private void execute(ConsumerRecord<String, String> register) {

        String participantStr = register.value();
        log.info("Voto recebido = {}", participantStr);

        ObjectMapper mapper = new ObjectMapper();
        ParticipantModel participant = null;

        try {
            participant = mapper.readValue(participantStr, ParticipantModel.class);
        } catch (JsonProcessingException ex) {
            log.error("Falha ao converter voto [{}]", participantStr, ex);
            return;
        }

        VoteModel voting = new VoteModel(null, participant, new Date());
        VoteModel entity = repository.save(voting);

        log.info("Voto registrado com sucesso [id={}, dataHora={}]", entity.getId(), entity.getDateHour());
    }

}
