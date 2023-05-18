package hu.uni.miskolc.second.models.subModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Profile {
  private String _id;
  private String[] rights;
}