package hu.uni.miskolc.second.models.subModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Hardware {
  private String motherboard;
  private String CPU;
  private String GPU;
  private String memory;
}
