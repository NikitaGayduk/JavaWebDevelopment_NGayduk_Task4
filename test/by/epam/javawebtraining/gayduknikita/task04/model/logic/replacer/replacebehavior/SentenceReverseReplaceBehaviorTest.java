package by.epam.javawebtraining.gayduknikita.task04.model.logic.replacer.replacebehavior;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;
import by.epam.javawebtraining.gayduknikita.task04.model.entity.CompositeUnit;
import by.epam.javawebtraining.gayduknikita.task04.model.entity.SimpleUnit;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SentenceReverseReplaceBehaviorTest {
    private SentenceReverseReplaceBehavior behavior = new SentenceReverseReplaceBehavior();

    private AbstractUnit[] data = {
            new SimpleUnit("This", AbstractUnit.UnitType.WORD),
            new SimpleUnit("sentence", AbstractUnit.UnitType.WORD),
            new SimpleUnit("was", AbstractUnit.UnitType.WORD),
            new SimpleUnit("maid", AbstractUnit.UnitType.WORD),
            new SimpleUnit("for", AbstractUnit.UnitType.WORD),
            new SimpleUnit("test", AbstractUnit.UnitType.WORD),
            new SimpleUnit(".", AbstractUnit.UnitType.PUNCTUATION_MARK)
    };

    private CompositeUnit sentence = new CompositeUnit();
    private CompositeUnit resultSentence = new CompositeUnit();

    @Before
    public void setData(){
        sentence.setUnitType(AbstractUnit.UnitType.SENTENCE);
        sentence.addUnit(data[0]);
        sentence.addUnit(data[1]);
        sentence.addUnit(data[2]);
        sentence.addUnit(data[3]);
        sentence.addUnit(data[4]);
        sentence.addUnit(data[5]);
        sentence.addUnit(data[6]);
    }

    @Test
    public void replaceTest() {
        List<AbstractUnit> dataList = new ArrayList<>();
        dataList.add(sentence);

        resultSentence.addUnit(data[6]);
        resultSentence.addUnit(data[5]);
        resultSentence.addUnit(data[4]);
        resultSentence.addUnit(data[3]);
        resultSentence.addUnit(data[2]);
        resultSentence.addUnit(data[1]);
        resultSentence.addUnit(data[0]);

        behavior.replace(dataList);

        assertEquals(resultSentence,sentence);
    }
}