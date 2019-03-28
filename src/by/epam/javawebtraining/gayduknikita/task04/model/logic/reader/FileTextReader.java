package by.epam.javawebtraining.gayduknikita.task04.model.logic.reader;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileTextReader implements TextReader {
    private static Logger logger = Logger.getRootLogger();
    private String fileName;

    public FileTextReader(String filename) {
        this.fileName = filename;
    }


    @Override
    public CharSequence read() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));) {
            StringBuilder result = new StringBuilder();
            String tmp;

            while ((tmp = reader.readLine()) != null){
                result.append(tmp + "\n");
            }

            return result;
        } catch (FileNotFoundException exc) {
            logger.error("File not found");
            throw new FileNotFoundException("File not found");
        } catch (IOException exc) {
            logger.error("Some error occurred while trying to read the file");
            throw new IOException("Some error occurred while trying to read the file");
        }
    }
}
