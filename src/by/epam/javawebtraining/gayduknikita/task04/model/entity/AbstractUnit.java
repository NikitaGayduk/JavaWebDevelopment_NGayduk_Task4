package by.epam.javawebtraining.gayduknikita.task04.model.entity;

public abstract class AbstractUnit {
    private UnitType unitType;

    /**
     * This enum contain type of text unit. We can use it to understand,
     * what type of text contained inside object.
     */
    public enum UnitType {
        TEXT,
        PARAGRAPH,
        SENTENCE,
        WORD,
        PUNCTUATION_MARK,
        CODE_BLOCK,
        SPACE,
        EMPTY_STRING,
        NEW_ROW,
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
