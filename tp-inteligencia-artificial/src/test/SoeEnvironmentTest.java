package test;

import main.java.model.clips.SoeEnvironment;

/**
 * Created by alvaro.daniel.calace on 11/12/2016.
 */
public class SoeEnvironmentTest {

    public static void main(String[] args) {
        try {
            SoeEnvironment soe = new SoeEnvironment();
            soe.eval("(assert (Sintoma (Sensibilidad \"Calor\")))");
            soe.run();
            System.out.println("hola");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.exit(1);
        }
    }

}
