package by.epam.javawebtraining.gayduknikita.task04.model.logic.replacer.replacebehavior;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;
import by.epam.javawebtraining.gayduknikita.task04.model.entity.CompositeUnit;

import java.util.Collections;
import java.util.List;

public class SentenceReverseReplaceBehavior implements ReplaceBehavior {

    @Override
    public void replace(List<AbstractUnit> data) {
        for(AbstractUnit ptr : data){
            if (ptr instanceof CompositeUnit && ptr.getUnitType() == AbstractUnit.UnitType.SENTENCE){
                List<AbstractUnit> list = ((CompositeUnit)ptr).getUnitList();
                Collections.reverse(list);
                ((CompositeUnit)ptr).setUnitList(list);
            }
        }
    }
}
