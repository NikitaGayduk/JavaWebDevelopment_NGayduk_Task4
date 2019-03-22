package by.epam;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.*;
import by.epam.javawebtraining.gayduknikita.task04.model.logic.parser.*;
import by.epam.javawebtraining.gayduknikita.task04.model.logic.reader.FileTextReader;
import by.epam.javawebtraining.gayduknikita.task04.model.logic.writer.FileTextWriter;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        WordParser wordParser = new WordParser();
        SpaceParser spaceParser = new SpaceParser();
        AbstractParser sentenceParser = new SentenceParser();
        AbstractParser paragraphParser = new ParagraphParser();
        AbstractParser textParser = new TextParser();
        AbstractParser tabulationParser = new TabulationParser();

        //textParser.addParser(paragraphParser);
        //textParser.addParser(tabulationParser);

        sentenceParser.addParser(wordParser);
        sentenceParser.addParser(spaceParser);

        StringBuilder builder = new FileTextReader("E:/Java/JavaWebDevelopment_NGayduk_Task4/src/by/epam/dataexample.txt").read();
        System.out.println(builder.toString());

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");

        AbstractUnit unit = textParser.parse(builder);
        System.out.println(unit.toString());

       /* FileTextWriter writer = new FileTextWriter("E:/Java/JavaWebDevelopment_NGayduk_Task4/src/by/epam/writertext.txt");
        writer.write(unit);*/

    }

}

