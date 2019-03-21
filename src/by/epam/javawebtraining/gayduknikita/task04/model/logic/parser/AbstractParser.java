package by.epam.javawebtraining.gayduknikita.task04.model.logic.parser;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class AbstractParser {

    private ArrayList<AbstractParser> followingParsers;
    private int currentNextParser = 0;
    
    // TODO: 21.03.2019
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

    public void changeNextParser(){
        if (currentNextParser < followingParsers.size()-1){
            currentNextParser++;
        } else {
            currentNextParser = 0;
        }
        triedParsersCount++;
    }

    // TODO: 21.03.2019
    public boolean isAllTried(){
        return triedParsersCount == followingParsers.size();
    }

    public abstract AbstractUnit parse(StringBuilder text);

}
