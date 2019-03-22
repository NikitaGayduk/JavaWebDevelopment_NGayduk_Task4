package by.epam.javawebtraining.gayduknikita.task04.model.logic.writer;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;

import java.io.IOException;

public interface TextWriter {
    void write(AbstractUnit text) throws IOException;
}
