package by.epam.javawebtraining.gayduknikita.task04.model.logic.parser;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;

public class ParagraphParser extends BaseParser {
    public static final String REGEX = "(^)[A-Z].*(\\n|\\z)";
    private static final AbstractUnit.UnitType returningType = AbstractUnit.UnitType.PARAGRAPH;

    public ParagraphParser() {
        super(REGEX, returningType);
    }
}
