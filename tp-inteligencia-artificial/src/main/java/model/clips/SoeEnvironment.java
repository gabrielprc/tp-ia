package main.java.model.clips;

import net.sf.clipsrules.jni.Environment;

/**
 * Created by alvaro.daniel.calace on 11/12/2016.
 */
public class SoeEnvironment extends Environment {

    public SoeEnvironment() {
        super();
        super.loadFromResource("/main/clips/templates.clp");
        super.loadFromResource("/main/clips/rules.clp");
        super.loadFromResource("/main/clips/functions.clp");
    }

}
