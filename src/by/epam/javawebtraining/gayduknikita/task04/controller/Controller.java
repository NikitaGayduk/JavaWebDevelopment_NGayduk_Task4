package by.epam.javawebtraining.gayduknikita.task04.controller;

import by.epam.javawebtraining.gayduknikita.task04.model.logic.parser.*;
import by.epam.javawebtraining.gayduknikita.task04.model.logic.reader.FileTextReader;
import by.epam.javawebtraining.gayduknikita.task04.model.logic.reader.TextReader;
import by.epam.javawebtraining.gayduknikita.task04.model.logic.writer.FileTextWriter;
import by.epam.javawebtraining.gayduknikita.task04.model.logic.writer.TextWriter;

import java.io.IOException;

public class Controller {
    private static final String READER_PATH = "resources/dataexample.txt";
    private static final String WRITER_PATH = "resources/projectoutput.txt";


    private TextReader reader = new FileTextReader(READER_PATH);
    private TextWriter writer = new FileTextWriter(WRITER_PATH);

    private AbstractParser textParser = new TextParser();
    private AbstractParser paragraphParser = new ParagraphParser();
    private AbstractParser emptyStringParser = new EmptyStringParser();
    private AbstractParser nextLineSymbolParser = new NextLineSymbolParser();
    private AbstractParser codeBlockParser = new CodeBlockParser();
    private AbstractParser sentenceParser = new SentenceParser();
    private AbstractParser spaceParser = new SpaceParser();
    private AbstractParser wordParser = new WordParser();
    private AbstractParser punctuationParser = new PunctuationParser();


    /**
     * This method just for test. It's show, how chain parser works.
     */
    public void write() {

        textParser.addParser(paragraphParser);
        textParser.addParser(emptyStringParser);
        textParser.addParser(nextLineSymbolParser);

        paragraphParser.addParser(codeBlockParser);
        paragraphParser.addParser(sentenceParser);
        paragraphParser.addParser(spaceParser);

        sentenceParser.addParser(wordParser);
        sentenceParser.addParser(punctuationParser);
        sentenceParser.addParser(spaceParser);

        try {
            writer.write(textParser.parse(reader.read()));
        } catch (NullPointerException e) {
            System.out.println("Исходные данные не валидны: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Исключение: " + e.getMessage());
        }
    }
}
