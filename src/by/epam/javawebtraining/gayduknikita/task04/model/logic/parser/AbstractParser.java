package by.epam.javawebtraining.gayduknikita.task04.model.logic.parser;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;

public abstract class AbstractParser {

    private AbstractParser nextParser;

    public AbstractParser() {
        nextParser = null;
    }

    public AbstractParser(AbstractParser nextParser) {
        this.nextParser = nextParser;
    }

    public void setNextParser(AbstractParser nextParser) {
        this.nextParser = nextParser;
    }

    abstract AbstractUnit parse(String textFragment);

}
