package me.dio.coding.votacao.bbb.ms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import me.dio.coding.votacao.bbb.ms.model.VoteModel;

public interface VoteRepository extends MongoRepository<VoteModel, String> {

}
