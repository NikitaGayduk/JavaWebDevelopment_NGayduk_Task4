package by.epam.javawebtraining.gayduknikita.task04.model.logic.sorter.sortbehavior;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;

import java.util.List;

public interface SortBehavior {

    void sort(List<AbstractUnit> data);

    void reverseSort(List<AbstractUnit> data);

}
