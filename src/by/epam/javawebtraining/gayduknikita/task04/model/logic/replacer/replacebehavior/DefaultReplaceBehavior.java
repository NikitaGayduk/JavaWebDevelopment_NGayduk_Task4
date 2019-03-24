package by.epam.javawebtraining.gayduknikita.task04.model.logic.replacer.replacebehavior;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;
import org.apache.log4j.Logger;

import java.util.List;

public class DefaultReplaceBehavior  implements ReplaceBehavior{
    private static Logger logger = Logger.getRootLogger();

    @Override
    public void replace(List<AbstractUnit> data) {
        //plug method
        logger.warn("Trying to use default replacer");
    }
}
