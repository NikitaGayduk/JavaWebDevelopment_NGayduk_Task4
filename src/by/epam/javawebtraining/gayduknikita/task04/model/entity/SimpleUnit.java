package by.epam.javawebtraining.gayduknikita.task04.model.entity;

import java.util.Objects;

public class SimpleUnit extends AbstractUnit {
    private String text;
    private SimpleUnitType unitType;

    /**
     * This enum contain type of basic text unit. We can use it to understand,
     * what type of text contained inside object of SimpleUnit.
     */
    public enum SimpleUnitType {
        WORD,
        PUNCTUATION_MARK,
        CODE_BLOCK
    }

    public SimpleUnit() {

    }

    public SimpleUnit(String text, SimpleUnitType unitType) {
        this.text = text;
        this.unitType = unitType;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setUnitType(SimpleUnitType unitType) {
        this.unitType = unitType;
    }

    public SimpleUnitType getUnitType() {
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
        return getText();
    }
}
