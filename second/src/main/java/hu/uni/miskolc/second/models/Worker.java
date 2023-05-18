package hu.uni.miskolc.second.models;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Worker {
  @Id
  private String _id;
  private String name;
  private LocalDate birthdate;
  private Integer salary;
  private String[] profileIds;
}
