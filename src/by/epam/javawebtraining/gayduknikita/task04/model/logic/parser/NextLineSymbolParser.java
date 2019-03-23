package by.epam.javawebtraining.gayduknikita.task04.model.logic.parser;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;

public class NextLineSymbolParser extends BaseParser {
    private static final String REGEX = "\\A\\n";
    private static final AbstractUnit.UnitType returningType = AbstractUnit.UnitType.NEW_LINE;

    public NextLineSymbolParser() {
        super(REGEX, returningType);
    }
}
