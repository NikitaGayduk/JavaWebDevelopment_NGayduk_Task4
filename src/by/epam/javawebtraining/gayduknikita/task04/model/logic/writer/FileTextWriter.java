package by.epam.javawebtraining.gayduknikita.task04.model.logic.writer;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileTextWriter implements TextWriter {
    private static Logger logger = Logger.getRootLogger();
    private String fileName;

    public FileTextWriter(String filename) {
        this.fileName = filename;
    }

    @Override
    public void write(AbstractUnit text) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(text.toString());
        } catch (FileNotFoundException exc) {
            logger.error("File not found");
            throw new FileNotFoundException("File not found");
        } catch (IOException exc) {
            logger.error("Some error occurred while trying to write the file");
            throw new IOException("Some error occurred while trying to write the file");
        }

    }
}
