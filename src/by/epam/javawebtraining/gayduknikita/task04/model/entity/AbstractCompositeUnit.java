package by.epam.javawebtraining.gayduknikita.task04.model.entity;

import java.util.ArrayList;

public abstract class AbstractCompositeUnit extends AbstractUnit {

    private ArrayList<AbstractUnit> unitList;

    public AbstractCompositeUnit() {
        unitList = new ArrayList<>();
    }

    public AbstractCompositeUnit(ArrayList<AbstractUnit> unitList) {
        this.unitList = unitList;
    }

    public void setUnitList(ArrayList<AbstractUnit> unitList) {
        this.unitList = unitList;
    }

    public ArrayList<AbstractUnit> getUnitList() {
        return unitList;
    }

    abstract public String toString();
}
