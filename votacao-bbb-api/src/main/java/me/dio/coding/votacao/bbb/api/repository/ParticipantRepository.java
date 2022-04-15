package me.dio.coding.votacao.bbb.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import me.dio.coding.votacao.bbb.api.model.ParticipantModel;

public interface ParticipantRepository extends MongoRepository<ParticipantModel, String> {

}
