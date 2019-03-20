package by.epam.javawebtraining.gayduknikita.task04.model.logic.parser;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;
import by.epam.javawebtraining.gayduknikita.task04.model.entity.CompositeUnit;
import by.epam.javawebtraining.gayduknikita.task04.model.entity.SimpleUnit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser extends AbstractParser {
    private static final String REGEX = "^\\w.*?\\b";

    private Pattern pattern = Pattern.compile(REGEX);
    private Matcher matcher;

    @Override
    public AbstractUnit parse(String textFragment) {
        matcher = pattern.matcher(textFragment);
        if(matcher.find() == true) {
            return new SimpleUnit(matcher.group(), SimpleUnit.UnitType.WORD);
        } else {
            return new SimpleUnit(null,null);
        }
    }

}
