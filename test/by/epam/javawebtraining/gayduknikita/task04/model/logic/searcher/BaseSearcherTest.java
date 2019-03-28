package by.epam.javawebtraining.gayduknikita.task04.model.logic.searcher;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;
import by.epam.javawebtraining.gayduknikita.task04.model.entity.CompositeUnit;
import by.epam.javawebtraining.gayduknikita.task04.model.entity.SimpleUnit;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BaseSearcherTest {
    private Searcher searcher = new BaseSearcher();
    private AbstractUnit[] simpleUnitData = {
            new SimpleUnit("Long"
                    , AbstractUnit.UnitType.WORD),
            new SimpleUnit("."
                    , AbstractUnit.UnitType.PUNCTUATION_MARK),
            new SimpleUnit("Long test sentence fdfdfdf dfdfdffddf dsdsdfsdf."
                    , AbstractUnit.UnitType.SENTENCE),
            new SimpleUnit("Long test sentence fdfdfdf dfdfdffddf."
                    , AbstractUnit.UnitType.SENTENCE)
    };

    private CompositeUnit compositeUnitOuter = new CompositeUnit();
    private CompositeUnit compositeUnitInner = new CompositeUnit();


    @Before
    public void setData() {
        compositeUnitOuter.setUnitType(AbstractUnit.UnitType.TEXT);
        compositeUnitInner.setUnitType(AbstractUnit.UnitType.SENTENCE);

        compositeUnitOuter.addUnit(simpleUnitData[3]);
        compositeUnitOuter.addUnit(compositeUnitInner);

        compositeUnitInner.addUnit(simpleUnitData[0]);
        compositeUnitInner.addUnit(simpleUnitData[2]);
        compositeUnitInner.addUnit(simpleUnitData[1]);
    }

    @Test
    public void findAll() {
        List<AbstractUnit> result = new ArrayList<>();
        result.add(simpleUnitData[3]);
        result.add(compositeUnitInner);
        result.add(simpleUnitData[2]);

        List<AbstractUnit> data = searcher.findAll(((AbstractUnit) compositeUnitOuter), AbstractUnit.UnitType.SENTENCE);

        assertEquals(result.toString(),data.toString());

    }
}