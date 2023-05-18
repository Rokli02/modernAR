package hu.uni.miskolc.second.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import hu.uni.miskolc.second.enums.TaskDifficulty;
import hu.uni.miskolc.second.models.Task;

public interface TaskRepository extends MongoRepository<Task, String> {
  @Query("{ '_id': ?0 }")
  @Update("{ '$set': { 'difficulty': ?1 } }")
  long findByIdAndUpdateTaskDifficultyToX(String id, TaskDifficulty diff);
}
