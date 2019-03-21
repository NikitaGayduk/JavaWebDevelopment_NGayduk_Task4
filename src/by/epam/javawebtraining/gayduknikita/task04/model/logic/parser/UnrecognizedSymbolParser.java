package by.epam.javawebtraining.gayduknikita.task04.model.logic.parser;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;
import by.epam.javawebtraining.gayduknikita.task04.model.entity.SimpleUnit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnrecognizedSymbolParser extends AbstractParser {
    private static final String REGEX = "^.";
    private static final Pattern pattern = Pattern.compile(REGEX);

    private Matcher matcher = pattern.matcher("");

    @Override
    public AbstractUnit parse(StringBuilder text) {
        matcher.reset(text);
        if(matcher.find() == true) {
            String result = matcher.group();
            text.delete(0,result.length());
            return new SimpleUnit(result, SimpleUnit.UnitType.WORD);
        } else {
            return null;
        }
    }
}
