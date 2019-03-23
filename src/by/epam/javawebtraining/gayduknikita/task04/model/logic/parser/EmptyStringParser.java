package by.epam.javawebtraining.gayduknikita.task04.model.logic.parser;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;

public class EmptyStringParser extends BaseParser {
    private static final String REGEX = "\\A\\n\\n";
    private static final AbstractUnit.UnitType returningType = AbstractUnit.UnitType.EMPTY_STRING;

    public EmptyStringParser() {
        super(REGEX, returningType);
    }
}
