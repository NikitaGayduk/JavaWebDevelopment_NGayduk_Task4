package by.epam.javawebtraining.gayduknikita.task04.model.logic.writer;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileTextWriter implements TextWriter {
    private String fileName;

    public FileTextWriter(String filename) {
        this.fileName = filename;
    }

    @Override
    public void write(AbstractUnit text) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(text.toString());
        } catch (FileNotFoundException exc) {
            throw new FileNotFoundException("File not found");
        } catch (IOException exc) {
            throw new IOException("Some error occurred while trying to read the file");
        }

    }
}
