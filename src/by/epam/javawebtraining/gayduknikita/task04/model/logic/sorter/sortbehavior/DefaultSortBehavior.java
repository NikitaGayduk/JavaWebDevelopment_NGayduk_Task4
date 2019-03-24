package by.epam.javawebtraining.gayduknikita.task04.model.logic.sorter.sortbehavior;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;
import org.apache.log4j.Logger;

import java.util.List;

public class DefaultSortBehavior implements SortBehavior {
    private static Logger logger = Logger.getRootLogger();

    @Override
    public void sort(List<AbstractUnit> data) {
        //plug method
        logger.warn("Trying to use default sort");
    }

    @Override
    public void reverseSort(List<AbstractUnit> data) {
        //plug method
        logger.warn("Trying to use default reverse sort");
    }
}
