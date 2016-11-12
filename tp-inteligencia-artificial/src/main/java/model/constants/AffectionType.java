package main.java.model.constants;

public enum AffectionType {
	DENTAL(1, "Dental"),
	PERIODONTAL(2, "Periodontal"),
	TEMPOROMANDIBULAR(3, "Temporomandibular");
	
	public final int type;
	public final String label;
	
	private AffectionType(int type, String label) {
		this.type = type;
		this.label = label;
	}
	
	public static AffectionType getByType(Integer type) {
		if (type != null) {
			for (AffectionType t : values()) {
				if (t.type == type.intValue()) {
					return t;
				}
			}
		}
		return null;
	}
	
}
