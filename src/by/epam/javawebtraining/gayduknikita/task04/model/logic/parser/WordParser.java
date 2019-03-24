package by.epam.javawebtraining.gayduknikita.task04.model.logic.parser;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;

public class WordParser extends BaseParser {
    private static final String REGEX = "\\A\\w+";
    private static final AbstractUnit.UnitType returningType = AbstractUnit.UnitType.WORD;

    public WordParser() {
        super(REGEX, returningType);
    }
}
