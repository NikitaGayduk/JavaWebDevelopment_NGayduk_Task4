package by.epam.javawebtraining.gayduknikita.task04.model.logic.parser;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;

public class TabulationParser extends BaseParser {
    private static final String REGEX = "^\t";
    private static final AbstractUnit.UnitType returningType = AbstractUnit.UnitType.SENTENCE;

    public TabulationParser() {
        super(REGEX, returningType);
    }
}
