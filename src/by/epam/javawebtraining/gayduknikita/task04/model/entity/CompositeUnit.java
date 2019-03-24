package by.epam.javawebtraining.gayduknikita.task04.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CompositeUnit extends AbstractUnit {

    private List<AbstractUnit> unitList;


    public CompositeUnit() {
        unitList = new ArrayList<>();
    }

    public CompositeUnit(List<AbstractUnit> unitList, AbstractUnit.UnitType type) {
        this.unitList = unitList;
        setUnitType(type);
        setSize(countSize());
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

    private int countSize() {
        int size = 0;
        for(AbstractUnit ptr : getUnitList()){
            size += ptr.getSize();
        }
        return size;
    }

    @Override
    public int getSize() {
        return countSize();
    }

    public void setUnitList(List<AbstractUnit> unitList) {
        this.unitList = unitList;
        setSize(countSize());
    }

    public List<AbstractUnit> getUnitList() {
        return unitList;
    }

    public void addUnit(AbstractUnit unit) {
        this.unitList.add(unit);
        setSize(getSize() + unit.getSize());
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
