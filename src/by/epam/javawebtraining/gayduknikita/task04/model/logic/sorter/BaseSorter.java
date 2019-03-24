package by.epam.javawebtraining.gayduknikita.task04.model.logic.sorter;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;
import by.epam.javawebtraining.gayduknikita.task04.model.logic.sorter.sortbehavior.SortBehavior;

import java.util.List;

public class BaseSorter implements Sorter {

    private SortBehavior sortBehavior;

    @Override
    public void sort(List<AbstractUnit> data) {
        sortBehavior.sort(data);
    }

    @Override
    public void reverseSort(List<AbstractUnit> data) {
        sortBehavior.reverseSort(data);
    }

    public void setSortBehavior(SortBehavior sortBehavior) {
        this.sortBehavior = sortBehavior;
    }
}
