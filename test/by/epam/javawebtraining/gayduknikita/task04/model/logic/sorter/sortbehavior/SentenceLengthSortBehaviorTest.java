package by.epam.javawebtraining.gayduknikita.task04.model.logic.sorter.sortbehavior;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;
import by.epam.javawebtraining.gayduknikita.task04.model.entity.CompositeUnit;
import by.epam.javawebtraining.gayduknikita.task04.model.entity.SimpleUnit;
import by.epam.javawebtraining.gayduknikita.task04.model.logic.searcher.BaseSearcher;
import by.epam.javawebtraining.gayduknikita.task04.model.logic.searcher.Searcher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SentenceLengthSortBehaviorTest {
    Searcher searcher = new BaseSearcher();
    SentenceLengthSortBehavior behavior = new SentenceLengthSortBehavior();

    AbstractUnit[] simpleUnitData = {
            new SimpleUnit("Long test sentence fdfdfdf dfdfdffddf dsdsdfsdf gfgfgdfgdfgdfgdg sdfsd."
                    , AbstractUnit.UnitType.SENTENCE),
            new SimpleUnit("Long test sentence fdfdfdf dfdfdffddf dsdsdfsdf gfgfgdfgdfgdfgdg."
                    , AbstractUnit.UnitType.SENTENCE),
            new SimpleUnit("Long test sentence fdfdfdf dfdfdffddf dsdsdfsdf."
                    , AbstractUnit.UnitType.SENTENCE),
            new SimpleUnit("Long test sentence fdfdfdf dfdfdffddf."
                    , AbstractUnit.UnitType.SENTENCE)
    };


    CompositeUnit compositeUnitOuter = new CompositeUnit();
    CompositeUnit compositeUnitInner = new CompositeUnit();


    @BeforeClass
    public void setData() {
        compositeUnitInner.addUnit(simpleUnitData[0]);
        compositeUnitInner.addUnit(simpleUnitData[3]);
        compositeUnitOuter.addUnit(simpleUnitData[1]);
        compositeUnitOuter.addUnit(compositeUnitInner);
        compositeUnitInner.addUnit(simpleUnitData[2]);
    }

    @Test
    public void sortTest() {
        List<AbstractUnit> result = new ArrayList<>();
        result.add(simpleUnitData[0]);
        result.add(simpleUnitData[1]);
        result.add(simpleUnitData[2]);
        result.add(simpleUnitData[3]);

        List<AbstractUnit> data = searcher.findAll(compositeUnitOuter, AbstractUnit.UnitType.SENTENCE);
        behavior.sort(data);

        assertEquals(result.toString(),data.toString());
    }

    @Test
    public void reverseSortTest() {
        List<AbstractUnit> result = new ArrayList<>();
        result.add(simpleUnitData[3]);
        result.add(simpleUnitData[2]);
        result.add(simpleUnitData[1]);
        result.add(simpleUnitData[0]);

        List<AbstractUnit> data = searcher.findAll(compositeUnitOuter, AbstractUnit.UnitType.SENTENCE);
        behavior.reverseSort(data);

        assertEquals(result.toString(),data.toString());
    }
}