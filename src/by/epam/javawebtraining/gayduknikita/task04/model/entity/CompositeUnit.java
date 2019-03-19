package by.epam.javawebtraining.gayduknikita.task04.model.entity;

import java.util.ArrayList;
import java.util.Objects;

public class CompositeUnit extends AbstractUnit {

    private ArrayList<AbstractUnit> unitList;
    private UnitType unitType;

    /**
     * This enum contain type of composite text unit. We can use it to understand,
     * what type of text contained inside object of CompositeUnit.
     */
    public enum UnitType {
        TEXT,
        PARAGRAPH,
        SENTENCE
    }

    public CompositeUnit() {
        unitList = new ArrayList<>();
    }

    public CompositeUnit(ArrayList<AbstractUnit> unitList) {
        this.unitList = unitList;
    }

    public void setUnitList(ArrayList<AbstractUnit> unitList) {
        this.unitList = unitList;
    }

    public ArrayList<AbstractUnit> getUnitList() {
        return unitList;
    }

    public void addUnit(AbstractUnit unit) {
        this.unitList.add(unit);
    }

    public void setUnitType(CompositeUnit.UnitType unitType) {
        this.unitType = unitType;
    }

    public CompositeUnit.UnitType getUnitType() {
        return unitType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        CompositeUnit that = (CompositeUnit) o;
        return Objects.equals(getUnitList(), that.getUnitList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUnitList());
    }

    public String toString(){
        StringBuilder result = new StringBuilder();

        for(AbstractUnit ptr : getUnitList()){
            result.append(ptr);
        }

        return result.toString();
    }
}
