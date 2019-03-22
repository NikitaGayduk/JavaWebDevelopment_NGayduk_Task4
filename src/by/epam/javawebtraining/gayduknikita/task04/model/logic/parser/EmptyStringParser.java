package by.epam.javawebtraining.gayduknikita.task04.model.logic.parser;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;

public class EmptyStringParser extends BaseParser {
    private static final String REGEX = "^\\n\\n";
    private static final AbstractUnit.UnitType returningType = AbstractUnit.UnitType.NEW_LINE;

    public EmptyStringParser() {
        super(REGEX, returningType);
    }
}
