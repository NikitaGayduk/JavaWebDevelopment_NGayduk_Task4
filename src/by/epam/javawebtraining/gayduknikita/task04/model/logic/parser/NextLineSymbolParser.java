package by.epam.javawebtraining.gayduknikita.task04.model.logic.parser;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;
import by.epam.javawebtraining.gayduknikita.task04.model.entity.SimpleUnit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NextLineSymbolParser extends BaseParser {
    private static final String REGEX = "^\\n";
    private static final AbstractUnit.UnitType returningType = AbstractUnit.UnitType.SENTENCE;

    public NextLineSymbolParser() {
        super(REGEX, returningType);
    }
}
