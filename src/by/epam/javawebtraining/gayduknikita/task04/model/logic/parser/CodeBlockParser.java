package by.epam.javawebtraining.gayduknikita.task04.model.logic.parser;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;
import by.epam.javawebtraining.gayduknikita.task04.model.entity.SimpleUnit;

public class CodeBlockParser extends BaseParser {
    private static final String REGEX = "\\);|=.*;|\\{(?s).*\\}|\\) *\\{|\\).*throws.*\\{|for *\\(.*?(;|:)|\\.\\S*;";
    private static final AbstractUnit.UnitType returningType = AbstractUnit.UnitType.CODE_BLOCK;

    public CodeBlockParser() {
        super(REGEX, returningType);
    }


    @Override
    public AbstractUnit parse(StringBuilder text) {
        AbstractUnit result = super.parse(text);

        if (result != null) {
            result = new SimpleUnit(text.toString(), returningType);
        } else {
            result = null;
        }

        return result;
    }
}
