package by.epam.javawebtraining.gayduknikita.task04.controller;

import by.epam.javawebtraining.gayduknikita.task04.model.logic.parser.*;
import by.epam.javawebtraining.gayduknikita.task04.model.logic.reader.FileTextReader;
import by.epam.javawebtraining.gayduknikita.task04.model.logic.reader.TextReader;
import by.epam.javawebtraining.gayduknikita.task04.model.logic.writer.FileTextWriter;
import by.epam.javawebtraining.gayduknikita.task04.model.logic.writer.TextWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;

public class Controller {
    File fileInput = new File("dataexample.txt");
    File fileOutput = new File("projectoutput.txt");
    TextReader reader = new FileTextReader(fileInput.getAbsolutePath());
    //TextReader reader = new FileTextReader("D:/Nikita/TextParser/src/by/epam/dataexample.txt");
    TextWriter writer = new FileTextWriter("/dataexample.txt");

    AbstractParser textParser = new TextParser();
    AbstractParser paragraphParser = new ParagraphParser();
    AbstractParser emptyStringParser = new EmptyStringParser();

    AbstractParser nextLineSymbolParser = new NextLineSymbolParser();
    AbstractParser sentenceParser = new SentenceParser();
    AbstractParser spaceParser = new SpaceParser();

    public void write(){
        /*textParser.addParser(paragraphParser);
        textParser.addParser(emptyStringParser);*/
        try {
            StringBuilder text = reader.read();
            //System.out.println(text);
            //writer.write(textParser.parse(reader.read()));
        } catch (IOException e){
            System.out.println("Исключение: " + e.getMessage());
        }

    }

}
