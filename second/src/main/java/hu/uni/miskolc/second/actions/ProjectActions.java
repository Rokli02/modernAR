package hu.uni.miskolc.second.actions;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.uni.miskolc.second.models.Project;
import hu.uni.miskolc.second.repositories.ProjectRepository;

@Component
public class ProjectActions {
  @Autowired
  private ProjectRepository projectRepository;

  public void createSomeProject() {
    System.out.println("ProjectActions - createSomeProject\n");
    final var list = new ArrayList<Project>();

    list.add(new Project(
      null,
      "Abdul Aladár",
      "X-vegyszer",
      LocalDate.of(2022, 5, 16),
      LocalDate.of(2024, 12, 20)
    ));
    list.add(new Project(
      null,
      "Barnabás Hamied",
      "*****",
      null,
      LocalDate.of(2026, 2, 4)
    ));
    list.add(new Project(
      null,
      "Tim Farolta",
      "No Pain - No ???",
      null,
      null
    ));

    projectRepository.insert(list);
  }
  public void printAllProject() {
    System.out.println("ProjectActions - printAllProject\n");

    projectRepository.findAll().forEach(System.out::println);
    System.out.println();
  }
  public void updateAllStartDateToNow() {
    System.out.println("ProjectActions - updateStartDateToNow\n");

    projectRepository.updateAllStartDateToX(LocalDate.now());
  }
  public void deleteById(String id) {
    System.out.println("ProjectActions - deleteById\n");

    projectRepository.deleteById(id);
  }
}
