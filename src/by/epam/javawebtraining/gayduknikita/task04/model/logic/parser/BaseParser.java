package by.epam.javawebtraining.gayduknikita.task04.model.logic.parser;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;
import by.epam.javawebtraining.gayduknikita.task04.model.entity.CompositeUnit;
import by.epam.javawebtraining.gayduknikita.task04.model.entity.SimpleUnit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseParser extends AbstractParser {
    private String REGEX;

    private AbstractUnit.UnitType returningType;

    private Pattern pattern;


    private Matcher matcher;


    protected BaseParser(String regex, AbstractUnit.UnitType returningType) {
        REGEX = regex;
        pattern = Pattern.compile(REGEX);
        matcher = pattern.matcher("");
    }

    @Override
    public AbstractUnit parse(StringBuilder text) {
        matcher.reset(text);

        if (matcher.find()) {
            StringBuilder parsedText = new StringBuilder();
            parsedText.append(matcher.group());
            AbstractUnit result;

            if (getNextParser() == null) {
                result = new SimpleUnit(parsedText.toString(), returningType);
            } else {
                result = new CompositeUnit();
                AbstractUnit unit;

                while (parsedText.length() > 0) {
                    unit = getNextParser().parse(parsedText);
                    if (unit != null) {
                        ((CompositeUnit) result).addUnit(unit);
                        //TODO: if regex start without ^ this will work wrong
                        parsedText.delete(0, unit.toString().length()); // TODO: 21.03.2019 think, maybe better add int charSize in AbstractUnit
                        tryCountReset();
                    } else if (!changeNextParser()) {
                        parsedText.delete(0, 1);
                    }
                }
            }
            return result;
        } else {
            return null;
        }
    }
}
