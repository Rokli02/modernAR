package hu.uni.miskolc.second.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import hu.uni.miskolc.second.models.Worker;

public interface WorkerRepository extends MongoRepository<Worker, String> {
  @Query("{ 'salary': { '$exists': true } }")
  @Update("{ '$inc': { 'salary': ?0 } }")
  long findAndIncrementSalaryByXIfExists(int inc);
}
