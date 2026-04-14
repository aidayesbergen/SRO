import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class sro {

    // лог файл аты
    private static final String FILE_NAME = "system.log";

    // уақыт форматы
    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // ===== LOG METHOD =====
    public static void writeLog(String action){

        String time = LocalDateTime.now().format(formatter);

        try(FileWriter writer = new FileWriter(FILE_NAME,true)){

            writer.write(time + " | " + action + "\n");

        }catch(IOException e){
            System.out.println("Log error: " + e.getMessage());
        }
    }

    // ===== TEST =====
    public static void main(String[] args) {

        writeLog("User LOGIN");
        writeLog("Student added");
        writeLog("Student updated");
        writeLog("ERROR: wrong data");

        System.out.println("Log saved!");
    }
}