package by.epam.javawebtraining.gayduknikita.task04.model.entity;

import java.util.Objects;

public class SimpleUnit extends AbstractUnit {
    private String text;

    public SimpleUnit() {

    }

    public SimpleUnit(String text, UnitType type) {
        this.text = text;
        setUnitType(type);
    }


    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SimpleUnit that = (SimpleUnit) o;
        return Objects.equals(getText(), that.getText()) &&
                getUnitType() == that.getUnitType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getText(), getUnitType());
    }

    public String toString() {
        if (this.text != null) {
            return getText();
        } else {
            return null;
        }
    }
}
