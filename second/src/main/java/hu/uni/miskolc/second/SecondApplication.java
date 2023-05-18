package hu.uni.miskolc.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hu.uni.miskolc.second.actions.*;
import hu.uni.miskolc.second.constants.Actions;
import hu.uni.miskolc.second.repositories.GeneralRepository;

@SpringBootApplication
public class SecondApplication implements CommandLineRunner {
	@Autowired
	private ComputerActions computerActions;
	@Autowired
	private WorkerActions workerActions;
	@Autowired
	private ProjectActions projectActions;
	@Autowired
	private TaskActions taskActions;
	@Autowired
	private GeneralRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SecondApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("\nApplication Run:\nFor more information type in 'help'!\n");
		String[] input;

		try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in, Charset.forName("UTF-8")))) {
			do {
				String tempInput = in.readLine();
				if (tempInput.startsWith("query ")) {
					input = tempInput.split(" ", 3);
				} else {
					input = tempInput.split(" ");
				}

				switch (input[0]) {
					case Actions.QUIT:
						System.out.println("\nKilépés!");
						break;
					case Actions.HELP:
						System.out.println(Actions.HELP_TEXT);
						break;
					case Actions.ACTION_LIST:
						System.out.println(Actions.ACTION_TEXT);
						break;
					case "c0":
						computerActions.printAllComputer();
						break;
					case "c1":
						computerActions.createSomeComputer();
						break;
					case "c2":
						computerActions.updateFromWin7ToWin8();
						break;
					case "c3":
						if (input.length >= 2) {
							computerActions.deleteById(input[1]);
						} else {
							System.out.println(Actions.COULDNT_DELETE_MISSING_ID);
						}
						break;
					case "w0":
						workerActions.printAllWorker();
						break;
					case "w1":
						workerActions.createSomeWorker();
						break;
					case "w2":
						if (input.length >= 2) {
							workerActions.incrementWorkerSalary(input[1]);
						} else {
							System.out.println(Actions.COULDNT_UPDATE_MISSING_ARGUMENT);
						}
						break;
					case "w3":
						if (input.length >= 2) {
							workerActions.deleteById(input[1]);
						} else {
							System.out.println(Actions.COULDNT_DELETE_MISSING_ID);
						}
						break;
					case "p0":
						projectActions.printAllProject();
						break;
					case "p1":
						projectActions.createSomeProject();
						break;
					case "p2":
						projectActions.updateAllStartDateToNow();
						break;
					case "p3":
						if (input.length >= 2) {
							projectActions.deleteById(input[1]);
						} else {
							System.out.println(Actions.COULDNT_DELETE_MISSING_ID);
						}
						break;
					case "t0":
						taskActions.printAllTask();
						break;
					case "t1":
						taskActions.createSomeTask();
						break;
					case "t2":
						if (input.length >= 3) {
							taskActions.updateTaskDifficulty(input[1], input[2]);
						} else {
							System.out.println(Actions.COULDNT_UPDATE_MISSING_ARGUMENT);
						}
						break;
					case "t3":
						if (input.length >= 2) {
							taskActions.deleteById(input[1]);
						} else {
							System.out.println(Actions.COULDNT_DELETE_MISSING_ID);
						}
						break;
					case "query":
						if (input.length >= 3) {
							var result = repository.query(input[1], input[2]);
							if (result == null || result.isEmpty()) {
								System.out.println("Üres lekérdezés válasz!");
								break;
							}

							for (Object element : result.toArray(new Object[result.size()])) {
								System.out.println(element.toString());
							}
						} else if (input.length == 2 && input[1].equals("collections")) {
							var result = repository.collectionNames();
							if (result == null || result.isEmpty()) {
								System.out.println("Még nincsennek kollekciók!");
								break;
							}

							StringBuilder sb = new StringBuilder("[ ");
							for (Object element : result) {
								sb.append(element.toString());
								sb.append(" - ");
								System.out.println(element.toString());
							}
							int length = sb.length();
							sb.delete(length - 3, length);
							sb.append(" ]");
							System.out.println(sb.toString());

						} else {
							System.out.println(Actions.COULDNT_QUERY_MISSING_ARGUMENT);
						}

						System.out.println();
						break;
					default:
					System.out.println("\nIsmeretlen parancs, próbáld meg újra csak mással!\n");
						break;
				}
			} while (!input[0].equals("quit"));
		} catch (RuntimeException | IOException re) {
			re.printStackTrace();
		}
	}
}
