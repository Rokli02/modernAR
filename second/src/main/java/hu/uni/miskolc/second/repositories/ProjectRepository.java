package hu.uni.miskolc.second.repositories;

import java.time.LocalDate;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import hu.uni.miskolc.second.models.Project;

public interface ProjectRepository extends MongoRepository<Project, String> {
  @Query("{ 'startDate': { '$exists': false } }")
  @Update("{ '$set': { 'startDate': ?0 } }")
  public void updateAllStartDateToX(LocalDate x);
}
