package hu.uni.miskolc.second.models;

import org.springframework.data.annotation.Id;

import hu.uni.miskolc.second.enums.TaskDifficulty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task {
  @Id
  private String _id;
  private String name;
  private String description;
  private TaskDifficulty difficulty;
  private String projectName;
  private String developerName;
}