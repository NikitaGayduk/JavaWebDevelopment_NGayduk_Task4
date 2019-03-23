package by.epam.javawebtraining.gayduknikita.task04.model.logic.parser;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;
import by.epam.javawebtraining.gayduknikita.task04.model.entity.CompositeUnit;
import by.epam.javawebtraining.gayduknikita.task04.model.entity.SimpleUnit;
import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseParser extends AbstractParser {
    private static Logger logger = Logger.getRootLogger();
    private String REGEX;

    private AbstractUnit.UnitType returningType;

    private Pattern pattern;


    private Matcher matcher;


    public BaseParser(String regex, AbstractUnit.UnitType returningType) {
        REGEX = regex;
        this.returningType = returningType;
        pattern = Pattern.compile(REGEX);
        matcher = pattern.matcher("");
    }

    @Override
    public AbstractUnit parse(StringBuilder text) {
        matcher.reset(text);
        AbstractUnit result;

        if (matcher.find()) {
            StringBuilder parsedText = new StringBuilder();
            parsedText.append(matcher.group());

            result = transferToNextParser(parsedText);
        } else {
            result = null;
        }
        return result;
    }

    private AbstractUnit transferToNextParser(StringBuilder parsedText){
        AbstractUnit result;

        if (getNextParser() != null) {
            result = new CompositeUnit();
            AbstractUnit unit;

            while (parsedText.length() > 0) {
                unit = getNextParser().parse(parsedText);

                if (unit != null) {
                    ((CompositeUnit) result).addUnit(unit);

                    //if regex start without \A this can work wrong
                    parsedText.delete(0, unit.toString().length()); // TODO: 21.03.2019 think, maybe better add int charSize in AbstractUnit
                    triedParsersCountReset();
                } else if (!changeNextParser()) {
                    ((CompositeUnit) result).addUnit(new SimpleUnit(parsedText.substring(0,1),AbstractUnit.UnitType.UNRECOGNIZED_SYMBOL));
                    logger.trace("Deleted unresolved symbol " + parsedText.substring(0,1));
                    parsedText.delete(0, 1);
                }
            }
            switchNextParserOnFirst();

        } else {
            result = new SimpleUnit(parsedText.toString(), returningType);
            logger.trace("Create simple unit. Type: " + returningType + "\n" + result.toString() + "\n");
        }
        return result;
    }
}
