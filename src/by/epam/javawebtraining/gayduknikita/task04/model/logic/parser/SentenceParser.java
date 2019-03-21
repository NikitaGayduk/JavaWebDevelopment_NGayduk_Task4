package by.epam.javawebtraining.gayduknikita.task04.model.logic.parser;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;
import by.epam.javawebtraining.gayduknikita.task04.model.entity.CompositeUnit;
import by.epam.javawebtraining.gayduknikita.task04.model.entity.SimpleUnit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends AbstractParser {
    private static final String REGEX;// = "^[A-Z].*?(\\.\\.\\.|!|\\?|\\.)";

    private static final Pattern pattern = Pattern.compile(REGEX);

    private static final AbstractUnit.UnitType returningType = AbstractUnit.UnitType.SENTENCE;

    private Matcher matcher = pattern.matcher("");

    public SentenceParser(){
        REGEX = "^[A-Z].*?(\\.\\.\\.|!|\\?|\\.)";
    }

    public SentenceParser(AbstractParser nextParser) {
        super(nextParser);
    }

    @Override
    public AbstractUnit parse(StringBuilder text) {
        matcher.reset(text);

        if (matcher.find()) {
            StringBuilder sentence = new StringBuilder();
            sentence.append(matcher.group());
            AbstractUnit result;

            if (getNextParser() == null) {
                result = new SimpleUnit(sentence.toString(), returningType);
            } else {
                result = new CompositeUnit();
                AbstractUnit unit;

                while (sentence.length() > 0) {
                    unit = getNextParser().parse(sentence);
                    if (unit != null) {
                        ((CompositeUnit)result).addUnit(unit);
                        //TODO: if regex start without ^ this will work wrong
                        sentence.delete(0, unit.toString().length()); // TODO: 21.03.2019 think, maybe better add int charSize in AbstractUnit
                    } else if(!changeNextParser()){
                        sentence.delete(0,1);
                    }
                }
            }
            return result;
        } else {
            return null;
        }
    }
}
