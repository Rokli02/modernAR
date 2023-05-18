package hu.uni.miskolc.second.enums;

public enum TaskDifficulty {
  EASY(0),
  STRAIGHTFORWARD(1),
  SIMPLE(3),
  MEDIUM(5),
  HARD(7),
  DIFFICULT(8),
  EXTREMELY_HARD(10);
  
  private int value;
  private TaskDifficulty(int value) {
    this.value = value;
  }
  public int getValue() {
    return value;
  }

  public static String getKeys() {
    StringBuilder sb = new StringBuilder("[");

    for (TaskDifficulty diff : TaskDifficulty.values()) {
      sb.append(diff.toString());
      sb.append(" - ");
    }

    int length = sb.length();
    sb.delete(length - 3, length);
    sb.append("]");
    return sb.toString();
  }
}
