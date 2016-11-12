package main.java.model.clips;

import main.java.model.beans.Affection;
import main.java.model.constants.AffectionType;
import main.java.model.dao.AffectionDao;

import java.util.HashMap;
import java.util.List;

/**
 * Created by alvaro.daniel.calace on 11/12/2016.
 */
public final class AffectionMapper {
    private static final HashMap<String, AffectionType> affectionTypeMap;

    static {
        affectionTypeMap = new HashMap<>();
        AffectionDao dao = new AffectionDao();
        List<Affection> affections = dao.list();
        for (Affection a : affections) {
            affectionTypeMap.put(a.getName(), AffectionType.getByType(a.getTypeInt()));
        }
    }

    public static AffectionType getType(String name) {
        return affectionTypeMap.getOrDefault(name, AffectionType.DENTAL);
    }
}
