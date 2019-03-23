package by.epam.javawebtraining.gayduknikita.task04.model.entity;

public abstract class AbstractUnit {
    private UnitType unitType = UnitType.DEFAULT;

    /**
     * This enum contain type of text unit. We can use it to understand,
     * what type of text contained inside object.
     */
    public enum UnitType {
        DEFAULT,
        TEXT,
        PARAGRAPH,
        SENTENCE,
        WORD,
        PUNCTUATION_MARK,
        CODE_BLOCK,
        SPACE,
        EMPTY_STRING,
        NEW_LINE,
        TABULATION,
        UNRECOGNIZED_SYMBOL
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    abstract public String toString();

}
