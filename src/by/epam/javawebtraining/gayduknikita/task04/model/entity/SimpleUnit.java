package by.epam.javawebtraining.gayduknikita.task04.model.entity;

import java.util.Objects;

public class SimpleUnit extends AbstractUnit {
    private String text;
    private UnitType unitType;

    /**
     * This enum contain type of basic text unit. We can use it to understand,
     * what type of text contained inside object of SimpleUnit.
     */
    public enum UnitType {
        WORD,
        PUNCTUATION_MARK,
        CODE_BLOCK,
        SPACE,
        EMPTY_STRING,
        NEW_ROW,
        TABULATION
    }

    public SimpleUnit() {

    }

    public SimpleUnit(String text, UnitType unitType) {
        this.text = text;
        this.unitType = unitType;
    }


    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setUnitType(SimpleUnit.UnitType unitType) {
        this.unitType = unitType;
    }

    public SimpleUnit.UnitType getUnitType() {
        return unitType;
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
