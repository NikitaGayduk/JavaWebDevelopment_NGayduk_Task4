package by.epam.javawebtraining.gayduknikita.task04.model.logic.searcher;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;
import by.epam.javawebtraining.gayduknikita.task04.model.entity.CompositeUnit;
import by.epam.javawebtraining.gayduknikita.task04.model.entity.SimpleUnit;

import java.util.ArrayList;
import java.util.List;

public class BaseSearcher implements Searcher{

    @Override
    public List<AbstractUnit> findAll(AbstractUnit text, AbstractUnit.UnitType type) {
        ArrayList<AbstractUnit> result = new ArrayList();

        if (text instanceof SimpleUnit) {
            if (text.getUnitType() == type) {
                result.add(text);
            }
        } else if (text instanceof CompositeUnit) {

            if (text.getUnitType() == type) {
                result.add(text);
            }

            List<AbstractUnit> value;

            for (AbstractUnit ptr : ((CompositeUnit) text).getUnitList()) {
                if (!(value = findAll(ptr, type)).isEmpty()) {
                    result.addAll(value);
                }
            }
        }
        return result;
    }
}