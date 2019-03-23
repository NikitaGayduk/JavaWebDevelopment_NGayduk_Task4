package by.epam.javawebtraining.gayduknikita.task04.model.logic.parser;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;
import by.epam.javawebtraining.gayduknikita.task04.model.entity.SimpleUnit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnrecognizedSymbolParser extends BaseParser {
    private static final String REGEX = "\\A.";
    private static final AbstractUnit.UnitType returningType = AbstractUnit.UnitType.UNRECOGNIZED_SYMBOL;

    public UnrecognizedSymbolParser() {
        super(REGEX, returningType);
    }
}
