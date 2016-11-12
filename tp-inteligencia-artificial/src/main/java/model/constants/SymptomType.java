package main.java.model.constants;

public enum SymptomType {
	SENSITIVITY(1, "Sensibilidad"),
	PAIN(2, "Dolor"),
	INFLAMATION(3, "Inflamacion"),
	ORAL_HEALTH(4, "Salud");
	
	public final int type;
	public final String label;
	
	private SymptomType(int type, String label) {
		this.type = type;
		this.label = label;
	}
	
	public static SymptomType getByType(Integer type) {
		if (type != null) {
			for (SymptomType s : values()) {
				if (s.type == type.intValue()) {
					return s;
				}
			}
		}
		return null;
	}
}
