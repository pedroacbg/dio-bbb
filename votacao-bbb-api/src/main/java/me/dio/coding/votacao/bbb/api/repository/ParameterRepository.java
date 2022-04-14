package me.dio.coding.votacao.bbb.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import me.dio.coding.votacao.bbb.api.model.ParameterModel;

public interface ParameterRepository extends MongoRepository<ParameterModel, String> {

}
