package by.epam.javawebtraining.gayduknikita.task04.model.logic.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileTextReader implements TextReader {
    private String fileName;

    public FileTextReader() {
    }

    public FileTextReader(String filename) {
        this.fileName = filename;
    }


    @Override
    public String read() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));) {
            StringBuilder result = new StringBuilder();
            String tmp;

            while ((tmp = reader.readLine()) != null){
                result.append(tmp + "\n");
            }

            return result.toString();
        } catch (FileNotFoundException exc) {
            throw new FileNotFoundException("File not found");
        } catch (IOException exc) {
            throw new IOException("Some error occurred while trying to read the file");
        }
    }
}
