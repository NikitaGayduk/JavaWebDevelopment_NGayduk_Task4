package by.epam.javawebtraining.gayduknikita.task04.model.logic.sorter.sortbehavior;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;
import by.epam.javawebtraining.gayduknikita.task04.model.logic.searcher.BaseSearcher;
import by.epam.javawebtraining.gayduknikita.task04.model.logic.searcher.Searcher;

import java.util.Collections;
import java.util.List;

public class SentenceLengthSortBehavior implements SortBehavior {

    @Override
    public void sort(List<AbstractUnit> data) {
        selectionSort(data);
    }

    @Override
    public void reverseSort(List<AbstractUnit> data) {
        selectionSort(data);
        Collections.reverse(data);
    }

    private void selectionSort(List<AbstractUnit> list) {
        for (int firstPtr = 0; firstPtr < list.size() - 1; firstPtr++) {
            int firstSize = list.get(firstPtr).getSize();
            int biggestSize = firstSize;
            int biggestPtr = firstPtr;

            for (int secondPtr = firstPtr + 1; secondPtr < list.size(); secondPtr++) {
                int secondSize = list.get(secondPtr).getSize();

                if (biggestSize < secondSize){
                    biggestSize = secondSize;
                    biggestPtr = secondPtr;
                }
            }

            if (biggestSize > firstSize){
                    AbstractUnit tmp = list.get(biggestPtr);
                    list.set(biggestPtr,list.get(firstPtr));
                    list.set(firstPtr,tmp);
            }
        }
    }
}
