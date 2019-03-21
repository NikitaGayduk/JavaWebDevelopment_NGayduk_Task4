package by.epam.javawebtraining.gayduknikita.task04.model.logic.parser;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class AbstractParser {

    private ArrayList<AbstractParser> followingParsers;
    private int currentNextParser = 0;

    private int triedParsersCount = 1;

    public AbstractParser() {
        followingParsers = new ArrayList<>();
    }

    public AbstractParser(AbstractParser ... followingParsers) {
        this.followingParsers = new ArrayList<>(Arrays.asList(followingParsers));
    }

    public AbstractParser(ArrayList<AbstractParser> followingParsers) {
        this.followingParsers = followingParsers;
    }

    public void addParser(AbstractParser parser) {
        this.followingParsers.add(parser);
    }

    public AbstractParser getNextParser() {
        if(followingParsers.isEmpty()){
            return null;
        }
        return followingParsers.get(currentNextParser);
    }

    /**
     * This method cyclically switch contained references on following parsers. If all parsers have been tried,
     * this method will return false and go on next circle.
     */
    public boolean changeNextParser(){
        if (currentNextParser < followingParsers.size()-1){
            currentNextParser++;
        } else {
            currentNextParser = 0;
        }
        triedParsersCount++;

        if (triedParsersCount > followingParsers.size()){
            triedParsersCount = 1;
            return false;
        }

        return true;
    }



    public abstract AbstractUnit parse(StringBuilder text);

}
