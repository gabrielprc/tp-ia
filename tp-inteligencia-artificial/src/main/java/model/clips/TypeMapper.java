package main.java.model.clips;

import main.java.model.beans.Affection;
import main.java.model.beans.Symptom;
import main.java.model.constants.AffectionType;
import main.java.model.constants.SymptomType;
import main.java.model.dao.AffectionDao;
import main.java.model.dao.GenericDao;
import main.java.model.dao.SymptomDao;

import java.util.HashMap;
import java.util.List;

/**
 * Created by alvaro.daniel.calace on 11/12/2016.
 */
public final class TypeMapper {
    private static final HashMap<String, AffectionType> affectionTypeMap;
    private static final HashMap<String, SymptomType> symptomTypeMap;

    static {
        affectionTypeMap = new HashMap<>();
        symptomTypeMap = new HashMap<>();
        (new AffectionDao()).list().forEach(a -> affectionTypeMap.put(a.getName(), AffectionType.getByType(a.getTypeInt())));
        (new SymptomDao()).list().forEach(s -> symptomTypeMap.put(s.getName(), SymptomType.getByType(s.getTypeInt())));
    }

    public static AffectionType getAffectionType(String name) {
        return affectionTypeMap.getOrDefault(name, AffectionType.DENTAL);
    }

    public static SymptomType getSymptomType(String name) {
        return symptomTypeMap.getOrDefault(name, SymptomType.PAIN);
    }
}
