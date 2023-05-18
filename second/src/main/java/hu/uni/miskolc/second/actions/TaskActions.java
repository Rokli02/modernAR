package hu.uni.miskolc.second.actions;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.uni.miskolc.second.enums.TaskDifficulty;
import hu.uni.miskolc.second.models.Task;
import hu.uni.miskolc.second.repositories.TaskRepository;

@Component
public class TaskActions {
  @Autowired
  private TaskRepository taskRepository;

  public void printAllTask() {
    System.out.println("TaskActions - printAllTask\n");

    taskRepository.findAll().forEach(System.out::println);
    System.out.println();
  }
  public void createSomeTask() {
    System.out.println("TaskActions - createSomeTask\n");
    final var list = new ArrayList<Task>();

    list.add(new Task(
      null,
      "Beton gerebjézés API",
      "A lemorzsolódott betondarabkákat összegyűjtő/gerebjéző szerver együttes.",
      TaskDifficulty.SIMPLE,
      null,
      "Kis Piricsi"
    ));

    taskRepository.insert(list);
  }
  public void updateTaskDifficulty(String id, String difficulty) {
    System.out.println("TaskActions - updateTaskDifficulty\n");

    try {
      TaskDifficulty diff = TaskDifficulty.valueOf(difficulty.toUpperCase());

      System.out.println(String.format("Updateable id: %s, difficulty: %s", id, diff));
      // long count = taskRepository.findByIdAndUpdateTaskDifficultyToX(id, diff);
    } catch (RuntimeException nfe) {
      System.out.println("Nem sikerült a feladat nehézséget módosítani!");
    }
  }
  public void deleteById(String id) {
    System.out.println("TaskActions - deleteById\n");

    taskRepository.deleteById(id);
  }
}
