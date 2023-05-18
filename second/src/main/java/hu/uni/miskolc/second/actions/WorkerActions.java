package hu.uni.miskolc.second.actions;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.uni.miskolc.second.models.Worker;
import hu.uni.miskolc.second.repositories.WorkerRepository;

@Component
public class WorkerActions {
  @Autowired
  private WorkerRepository workerRepository;
  
  public void createSomeWorker() {
    System.out.println("WorkerActions - createSomeWorker\n");
    final var list = new ArrayList<Worker>();

    list.add(new Worker(
      null,
      "Karcsú Elemér",
      LocalDate.of(1995, 7, 20),
      225000,
      new String[] { "4", "12345" }
    ));
    list.add(new Worker(
      null,
      "Tihadar Géza",
      LocalDate.of(1986, 11, 12),
      374999,
      new String[] { "23" }
    ));
    list.add(new Worker(
      null,
      "Kis Piricsi",
      null,
      null,
      new String[] { "13" }
    ));

    workerRepository.insert(list);
  }
  public void printAllWorker() {
    System.out.println("WorkerActions - printAllWorker\n");

    workerRepository.findAll().forEach(System.out::println);
    System.out.println();
  }
  public void incrementWorkerSalary(String inc) {
    System.out.println("WorkerActions - incrementWorkerSalary\n");

    try {
      int increment = Integer.parseInt(inc);
      if (increment == 0) {
        throw new NumberFormatException();
      }

      long count = workerRepository.findAndIncrementSalaryByXIfExists(increment);
      System.out.println(String.format("Sikeresen frissített %d dokumentumot", count));
    } catch (NumberFormatException nfe) {
      System.out.println("Nem sikerült a fizetéseket emelni!");
    }
  }
  public void deleteById(String id) {
    System.out.println("WorkerActions - deleteById\n");

    workerRepository.deleteById(id);
  }

}
