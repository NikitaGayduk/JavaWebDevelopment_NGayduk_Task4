package by.epam;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.*;
import by.epam.javawebtraining.gayduknikita.task04.model.logic.parser.SentenceParser;
import by.epam.javawebtraining.gayduknikita.task04.model.logic.parser.SpaceParser;
import by.epam.javawebtraining.gayduknikita.task04.model.logic.parser.WordParser;
import by.epam.javawebtraining.gayduknikita.task04.model.logic.reader.FileTextReader;
import by.epam.javawebtraining.gayduknikita.task04.model.logic.reader.TextReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        WordParser wordParser = new WordParser();
        SpaceParser spaceParser = new SpaceParser();
        SentenceParser sentenceParser = new SentenceParser();
        sentenceParser.addParser(wordParser);
        sentenceParser.addParser(spaceParser);

        StringBuilder builder = new StringBuilder("Fdsdsdd sfsfsfssf fsfsffs. Hbdsdhbshbd.");
        System.out.println(builder.toString());

        //AbstractUnit unit = spaceParser.parse(builder);
        AbstractUnit unit = sentenceParser.parse(builder);
        System.out.println(unit.toString());

        ArrayList<AbstractUnit> list = ((CompositeUnit)unit).getUnitList();

        System.out.println(list.get(1));

        System.out.println(builder.toString());
    }

}

