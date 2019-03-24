package by.epam.javawebtraining.gayduknikita.task04.model.logic.parser;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;

public class ParagraphParser extends BaseParser {
    private static final String REGEX = ("\\A[^\\n](?s).*?(?=\\n\\n)");

    private static final AbstractUnit.UnitType returningType = AbstractUnit.UnitType.PARAGRAPH;

    public ParagraphParser() {
        super(REGEX, returningType);
    }
}
