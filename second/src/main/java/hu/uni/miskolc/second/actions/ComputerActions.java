package hu.uni.miskolc.second.actions;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.uni.miskolc.second.models.Computer;
import hu.uni.miskolc.second.models.subModels.Hardware;
import hu.uni.miskolc.second.models.subModels.Profile;
import hu.uni.miskolc.second.repositories.ComputerRepository;

@Component
public final class ComputerActions {
  @Autowired
	private ComputerRepository computerRepository;
  
  public void createSomeComputer() throws RuntimeException {
    System.out.println("ComputerActions - createSomeComputer\n");
    var list = new ArrayList<Computer>();

    list.add(new Computer(
      null,
      new Hardware("Gigabyte gh6z", "i5 3650", "GT 730", "Kingston DDR3 4GB 1333Hz"),
      "Linux Ubuntu v10",
      new Profile[] { new Profile("12345", new String[] { "admin", "kocka" }) }
    ));
    list.add(new Computer(
      null,
      new Hardware("Asus tx2-k", "Ryzen 5 3600", "RX-270", "2 x Kingston DDR3 2GB 1600Hz"),
      "Windows 7",
      new Profile[] { new Profile("23", new String[] { "kocka" }), new Profile("13", new String[] { "böngésző" }) }
    ));
    list.add(new Computer(
      null,
      new Hardware("Asus tx4-m", "Ryzen 7 5600x3D", "GTX 1660Ti", "2 x Kingston DDR4 8GB 3200Hz"),
      "Windows 10",
      new Profile[] { new Profile("4", new String[] { "kocka", "streamer" }) }
    ));

    computerRepository.insert(list);
  }
  public void printAllComputer() {
    System.out.println("ComputerActions - printAllComputer\n");

    computerRepository.findAll().forEach(System.out::println);
    System.out.println();
  }
  public void updateFromWin7ToWin8() {
    System.out.println("ComputerActions - updateFromWin7ToWin8\n");

    computerRepository.updateOperationSystemXToY("Windows 7", "Windows 10");
  }
  public void deleteById(String id) {
    System.out.println("ComputerActions - deleteById\n");

    computerRepository.deleteById(id);
  }
}
