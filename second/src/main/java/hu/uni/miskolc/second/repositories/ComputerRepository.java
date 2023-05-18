package hu.uni.miskolc.second.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import hu.uni.miskolc.second.models.Computer;

public interface ComputerRepository extends MongoRepository<Computer, String> {

  @Query("{ 'operationSystem': ?0 }")
  @Update("{ '$set': { 'operationSystem': ?1 } }")
  void updateOperationSystemXToY(String x, String y);
}
