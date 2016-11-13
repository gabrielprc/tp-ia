package main.java.model.beans;

import main.java.model.constants.AffectionType;
import main.java.model.constants.RiskFactorType;
import main.java.model.constants.SymptomType;
import main.java.model.dao.AffectionDao;
import main.java.model.dao.RiskFactorDao;
import main.java.model.dao.SymptomDao;

import java.util.HashMap;

/**
 * Created by alvaro.daniel.calace on 11/12/2016.
 */
public final class TypeMapper {

    private static final HashMap<String, AffectionType> affectionTypeMap;
    private static final HashMap<String, SymptomType> symptomTypeMap;
    private static final HashMap<String, RiskFactorType> riskFactorTypeMap;

    static {
        affectionTypeMap = new HashMap<>();
        symptomTypeMap = new HashMap<>();
        riskFactorTypeMap = new HashMap<>();
        (new AffectionDao()).list().forEach(
                a -> affectionTypeMap.put(a.getName(), AffectionType.getByType(a.getTypeInt())));
        (new SymptomDao()).list().forEach(
                s -> symptomTypeMap.put(s.getName(), SymptomType.getByType(s.getTypeInt())));
        (new RiskFactorDao()).list().forEach(
                r -> riskFactorTypeMap.put(r.getName(), RiskFactorType.getByType(r.getTypeInt())));
    }

    public static AffectionType getAffectionType(String name) {
        return affectionTypeMap.getOrDefault(name, AffectionType.DENTAL);
    }

    public static SymptomType getSymptomType(String name) {
        return symptomTypeMap.getOrDefault(name, SymptomType.PAIN);
    }

    public static RiskFactorType getRiskFactorType(String name) {
        return riskFactorTypeMap.getOrDefault(name, RiskFactorType.DISEASE);
    }

}
