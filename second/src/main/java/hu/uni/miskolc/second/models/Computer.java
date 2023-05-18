package hu.uni.miskolc.second.models;

import org.springframework.data.annotation.Id;

import hu.uni.miskolc.second.models.subModels.Hardware;
import hu.uni.miskolc.second.models.subModels.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Computer {
  @Id
  private String _id;
  private Hardware hardware;
  private String operationSystem;
  private Profile[] profiles;
}
