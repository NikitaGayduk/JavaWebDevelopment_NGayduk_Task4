package by.epam.javawebtraining.gayduknikita.task04.model.logic.parser;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;

public class SentenceParser extends BaseParser {
    public static final String REGEX = "\\A[A-Z].*?(\\.\\.\\.|!|\\?|\\.|$)";
    private static final AbstractUnit.UnitType returningType = AbstractUnit.UnitType.SENTENCE;

    public SentenceParser() {
        super(REGEX, returningType);
    }
}
