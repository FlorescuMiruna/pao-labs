package pao.biblioteca;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Serviciu de audit, care scrie in fisierul Audit.csv numele actiunii, atunci cand aceasta este executata
 * si timpul exact cand a fost executata.
 */
public class AuditService {

    public static void WriteActionsToCSVFile(String action) {

        String path = "CSV_files\\Audit.csv";
        File file = new File(path);

        try{
            FileWriter fileWriter = new FileWriter(file,true);

            LocalDateTime time = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String timestamp = time.format(myFormatObj);

            fileWriter.append(action);
            fileWriter.append(",");
            fileWriter.append(timestamp);
            fileWriter.append("\n");
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
