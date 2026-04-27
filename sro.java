import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class sro {

    // имя файла
    private static final String FILE_NAME = "system.log";

    // формат времени
    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // ===== LOG METHOD =====
    public static void writeLog(String action){

        String time = LocalDateTime.now().format(formatter);
        String log = time + " | " + action;

        // запись в файл
        try(FileWriter writer = new FileWriter(FILE_NAME, true)){
            writer.write(log + "\n");
        }catch(IOException e){
            System.out.println("Log error: " + e.getMessage());
        }

        // вывод в терминал
        System.out.println(log);
    }

    // ===== MAIN =====
    public static void main(String[] args) {

        writeLog("User LOGIN");
        writeLog("Student added");
        writeLog("Student updated");
        writeLog("ERROR: wrong data");

        System.out.println("Log saved!");
    }
}