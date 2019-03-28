package by.epam.javawebtraining.gayduknikita.task04.model.logic.parser;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;
import by.epam.javawebtraining.gayduknikita.task04.model.entity.CompositeUnit;
import by.epam.javawebtraining.gayduknikita.task04.model.entity.SimpleUnit;
import org.junit.Test;

import static org.junit.Assert.*;

public class SentenceParserTest {
    private AbstractParser sentenceParser = new SentenceParser();
    private AbstractParser wordParser = new WordParser();
    private AbstractParser punctuationParser = new PunctuationParser();
    private AbstractParser spaceParser = new SpaceParser();

    private StringBuilder testSentence = new StringBuilder("Sentence for test.");


    @Test
    public void parseCompositeTest() {
        sentenceParser.addParser(wordParser);
        sentenceParser.addParser(punctuationParser);
        sentenceParser.addParser(spaceParser);

        CompositeUnit result = new CompositeUnit();
        result.setUnitType(AbstractUnit.UnitType.SENTENCE);

        AbstractUnit sentenceWord = new SimpleUnit("Sentence", AbstractUnit.UnitType.WORD);
        AbstractUnit space1 = new SimpleUnit(" ", AbstractUnit.UnitType.SPACE);
        AbstractUnit forWord = new SimpleUnit("for", AbstractUnit.UnitType.WORD);
        AbstractUnit space2 = new SimpleUnit(" ", AbstractUnit.UnitType.SPACE);
        AbstractUnit testWord = new SimpleUnit("test", AbstractUnit.UnitType.WORD);
        AbstractUnit dot = new SimpleUnit(".", AbstractUnit.UnitType.PUNCTUATION_MARK);

        result.addUnit(sentenceWord);
        result.addUnit(space1);
        result.addUnit(forWord);
        result.addUnit(space2);
        result.addUnit(testWord);
        result.addUnit(dot);

        assertEquals(((AbstractUnit) result), sentenceParser.parse(testSentence));
    }

    @Test
    public void parseSimpleTest() {
        sentenceParser = new SentenceParser();

        SimpleUnit result = new SimpleUnit("Sentence for test.", AbstractUnit.UnitType.SENTENCE);

        assertEquals(((AbstractUnit) result), sentenceParser.parse(testSentence));
    }
}