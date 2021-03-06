package by.epam.javawebtraining.gayduknikita.task04.model.logic.parser;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;

public class TextParser extends BaseParser {
    private static final String REGEX = "\\A(?s).*";
    private static final AbstractUnit.UnitType returningType = AbstractUnit.UnitType.TEXT;

    public TextParser() {
        super(REGEX, returningType);
    }
}
