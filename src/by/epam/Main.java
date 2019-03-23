package by.epam;


import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;
import by.epam.javawebtraining.gayduknikita.task04.model.entity.CompositeUnit;
import by.epam.javawebtraining.gayduknikita.task04.model.entity.SimpleUnit;
import by.epam.javawebtraining.gayduknikita.task04.model.logic.searcher.BaseSearcher;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        /*Controller controller = new Controller();
        controller.write();*/

        CompositeUnit compositeUnit = new CompositeUnit();
        compositeUnit.setUnitType(AbstractUnit.UnitType.TEXT);

        CompositeUnit compositeUnit1 = new CompositeUnit();
        compositeUnit1.setUnitType(AbstractUnit.UnitType.SENTENCE);

        CompositeUnit compositeUnit2 = new CompositeUnit();
        compositeUnit2.setUnitType(AbstractUnit.UnitType.WORD);

        SimpleUnit simpleUnit = new SimpleUnit("Blas", AbstractUnit.UnitType.WORD);
        SimpleUnit simpleUnit1 = new SimpleUnit("Blas1", AbstractUnit.UnitType.PUNCTUATION_MARK);
        SimpleUnit simpleUnit2 = new SimpleUnit("Blas2", AbstractUnit.UnitType.EMPTY_STRING);

        compositeUnit.addUnit(compositeUnit1);
        compositeUnit.addUnit(compositeUnit2);

        compositeUnit1.addUnit(simpleUnit);

        compositeUnit2.addUnit(simpleUnit1);
        compositeUnit2.addUnit(simpleUnit2);

        BaseSearcher baseSearcher = new BaseSearcher();
        ArrayList<AbstractUnit> list = new ArrayList<>();

        list.addAll(baseSearcher.findAll(simpleUnit, AbstractUnit.UnitType.NEW_LINE));
        System.out.println(list.size());
        for(AbstractUnit ptr : list){
            System.out.println("[" + ptr.getUnitType() + "]");
        }
    }

}

