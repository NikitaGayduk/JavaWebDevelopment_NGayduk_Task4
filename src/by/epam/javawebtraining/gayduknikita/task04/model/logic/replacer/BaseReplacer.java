package by.epam.javawebtraining.gayduknikita.task04.model.logic.replacer;

import by.epam.javawebtraining.gayduknikita.task04.model.entity.AbstractUnit;
import by.epam.javawebtraining.gayduknikita.task04.model.logic.replacer.replacebehavior.*;

import java.util.List;

public class BaseReplacer implements Replacer {
    private ReplaceBehavior behavior = new DefaultReplaceBehavior();

    public BaseReplacer(ReplaceBehavior behavior) {
        this.behavior = behavior;
    }

    @Override
    public void replace(List<AbstractUnit> data) {
        behavior.replace(data);
    }

    public void setBehavior(ReplaceBehavior behavior) {
        this.behavior = behavior;
    }
}
