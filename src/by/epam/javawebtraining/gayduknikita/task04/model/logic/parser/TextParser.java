package by.epam.javawebtraining.gayduknikita.task04.model.logic.parser;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;

public class TextParser extends BaseParser {
    public static final String REGEX = "(?s).*";
    private static final AbstractUnit.UnitType returningType = AbstractUnit.UnitType.TEXT;

    public TextParser() {
        super(REGEX, returningType);
    }
}
