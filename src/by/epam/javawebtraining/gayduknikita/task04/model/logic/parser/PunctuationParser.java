package by.epam.javawebtraining.gayduknikita.task04.model.logic.parser;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;

public class PunctuationParser extends BaseParser {
    public static final String REGEX = "^[[:punct:]]";
    private static final AbstractUnit.UnitType returningType = AbstractUnit.UnitType.PUNCTUATION_MARK;

    public PunctuationParser() {
        super(REGEX, returningType);
    }
}
