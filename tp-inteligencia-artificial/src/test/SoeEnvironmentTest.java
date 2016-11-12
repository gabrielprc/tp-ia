package test;

import main.java.model.beans.Prediction;
import main.java.model.clips.SoeEnvironment;
import net.sf.clipsrules.jni.*;

/**
 * Created by alvaro.daniel.calace on 11/12/2016.
 */
public class SoeEnvironmentTest {

    public static void main(String[] args) {
        try {
            SoeEnvironment soe = new SoeEnvironment();
            soe.reset();
            soe.eval("(assert (Sintoma (Sensibilidad \"Calor\")))");
            soe.run();
            String evalStr = "(get-presuncion-list)";
            MultifieldValue pv = (MultifieldValue) soe.eval(evalStr);
            System.out.println(pv);
            for (int i = 0; i < pv.size(); i++) {
                FactAddressValue fv = (FactAddressValue) pv.get(i);
                String trastorno = ((StringValue) fv.getFactSlot("PosibleTrastorno")).stringValue();
                String probabilidad = ((StringValue) fv.getFactSlot("Probabilidad")).stringValue();
                System.out.println(trastorno + " - " + probabilidad);
            }
        } catch (Throwable t) {
            System.out.println(t.getMessage());
            System.out.println(System.getProperty("java.library.path"));
        } finally {
            System.exit(1);
        }
    }

}
