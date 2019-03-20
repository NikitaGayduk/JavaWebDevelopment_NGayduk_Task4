package by.epam;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.*;
import by.epam.javawebtraining.gayduknikita.task04.model.logic.parser.WordParser;
import by.epam.javawebtraining.gayduknikita.task04.model.logic.reader.FileTextReader;
import by.epam.javawebtraining.gayduknikita.task04.model.logic.reader.TextReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        WordParser wordParser = new WordParser();
        System.out.println(wordParser.parse("1Nikita . Parse this sentence please").toString());
    }

}

