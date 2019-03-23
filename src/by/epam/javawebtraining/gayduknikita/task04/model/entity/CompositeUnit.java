package by.epam.javawebtraining.gayduknikita.task04.model.entity;

import java.util.ArrayList;
import java.util.Objects;

public class CompositeUnit extends AbstractUnit {

    private ArrayList<AbstractUnit> unitList;


    public CompositeUnit() {
        unitList = new ArrayList<>();
    }

    public CompositeUnit(ArrayList<AbstractUnit> unitList, AbstractUnit.UnitType type) {
        this.unitList = unitList;
        setUnitType(type);
    }

    public CompositeUnit(CompositeUnit compositeUnit) {
        this();
        for(AbstractUnit ptr : compositeUnit.unitList){
            if (ptr instanceof SimpleUnit){
                this.unitList.add(new SimpleUnit((SimpleUnit)ptr));
            } else if (ptr instanceof CompositeUnit){
                this.unitList.add(new CompositeUnit((CompositeUnit)ptr));
            }
        }
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
