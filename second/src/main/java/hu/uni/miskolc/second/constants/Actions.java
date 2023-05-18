package hu.uni.miskolc.second.constants;

import hu.uni.miskolc.second.enums.TaskDifficulty;

public class Actions {
  public final static String QUIT = "quit";
  public final static String HELP = "help";
  public final static String ACTION_LIST = "list";
  public final static String HELP_TEXT = """
    \nParancsok:
    \tquit - Kilép
    \thelp - Listázza a programvezérlő parancsokat
    \tlist - Listázza az adatbázis művelet parancsait
    \tquery [collection name] [filter] - Egyedi lekérdezés a megadott adatokkal
    \tquery collections - Az adatbázisban létrehozott kollekciók listája

  """;
  public final static String ACTION_TEXT = String.format("""
    \nParancsok:

    \tc0 - printAllComputer
    \tc1 - createSomeComputer
    \tc2 - updateFromWin7ToWin8
    \tc3 [computer id] - deleteById
    ------------------------------------------
    \tw0 - printAllWorker
    \tw1 - createSomeWorker
    \tw2 [increment by] - incrementWorkerSalary
    \tw3 [computer id] - deleteById

    ------------------------------------------
    \tp0 - printAllProject
    \tp1 - createSomeProject
    \tp2 - updateAllStartDateToNow
    \tp3 [computer id] - deleteById
    ------------------------------------------
    \tt0 - printAllTask
    \tt1 - createSomeTask
    \tt2 [task id] [new task difficulty] - updateTaskDifficulty
    \t   difficulties: %s
    \tt3 [computer id] - deleteById

  """, TaskDifficulty.getKeys());
  public final static String COULDNT_DELETE_MISSING_ID = "Nem sikerült a törlés, mert nem lett megadva ID!";
  public final static String COULDNT_UPDATE_MISSING_ARGUMENT = "Nem sikerült a módosítás, mert egy kötelező argumentuma nem lett megadva!";
  public final static String COULDNT_QUERY_MISSING_ARGUMENT = "Nem sikerült a lekérdezés, mert egy kötelező argumentuma nem lett megadva!";
}