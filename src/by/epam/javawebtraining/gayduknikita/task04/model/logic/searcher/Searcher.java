package by.epam.javawebtraining.gayduknikita.task04.model.logic.searcher;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;

import java.util.List;

public interface Searcher {

    List<AbstractUnit> findAll(AbstractUnit text, AbstractUnit.UnitType type);

}
